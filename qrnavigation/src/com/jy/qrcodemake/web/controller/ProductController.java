package com.jy.qrcodemake.web.controller;

import com.jy.qrcodemake.entity.Product;
import com.jy.qrcodemake.model.ProductModel;
import com.jy.qrcodemake.service.ProductServiceI;
import com.jy.qrcodemake.util.Unid;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController extends BaseController {
	@Autowired
	private ProductServiceI productService;

    /**
     * 获取二维码list
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("list")
	public String list(HttpSession session,HttpServletRequest request){
		List<Product> productList = productService.listProduct();
		List<ProductModel> pmList = new ArrayList<ProductModel>();
		String path = session.getServletContext().getRealPath("/")+"product\\";
		String realPath = "http://"+ request.getServerName()+ ":"+ request.getServerPort()+ request.getContextPath();
		System.out.println(realPath);
		System.out.println(path);
		for(Product p:productList){
			ProductModel pm = new ProductModel();
			BeanUtils.copyProperties(p, pm);
			
			//重新生成所有的qrcode
			String filename = pm.getScenicspotLink();
			ByteArrayOutputStream out = QRCode.from(realPath+"/product/"+pm.getScenicspotLink()).withSize(255, 255).to(ImageType.PNG).stream();
			try{
				FileOutputStream fout = new FileOutputStream(new File(path+filename.substring(0,filename.indexOf("."))+".png"));
				fout.write(out.toByteArray());
				fout.flush();
				fout.close();
			}catch(FileNotFoundException e){
				
			}catch(IOException e){
				
			}
			pm.setQrcodeLink(realPath+"/product/"+filename.substring(0,filename.indexOf("."))+".png");//单独设置生成二维码内容的链接
			pmList.add(pm);
		}
		request.setAttribute("productList", pmList);
		return "/product/qrcode_list";
	}
	@RequestMapping("/addPage")
	public String addPage(HttpSession session,HttpServletRequest request) {
		
		
		return "/product/qrcode_add";
	}
	@RequestMapping("/add")
	public String add(HttpServletRequest request,@RequestParam("files")MultipartFile[] mfile,@RequestParam("scenicspot_name")String scenicspot_name) throws IOException{
		String scenicspotName = scenicspot_name;//GlobalFunc.toString(request.getParameter("scenicspot_name"));
		String scenicspotBg = "";//GlobalFunc.toString(request.getParameter("scenicspot_bg"));
		String scenicspotWav = "";//GlobalFunc.toString(request.getParameter("scenicspot_wav"));
		String id = Unid.GetUnid();
		if (mfile !=null && mfile.length>0) {
            for (int i = 0;i<mfile.length;i++){
                long start = System.currentTimeMillis();
                System.out.println("-------------------------------------------------");
                System.out.println("获取文件流"+mfile[i].getInputStream());
                System.out.println("获取文件的字节大小【byte】"+mfile[i].getSize());
                System.out.println("文件类型"+mfile[i].getContentType());
                System.out.println("获取文件数据"+mfile[i].getBytes());
                System.out.println("文件名字"+mfile[i].getName());
                System.out.println("获取上传文件的原名"+mfile[i].getOriginalFilename());

                System.out.println("-------------------------------------------------");

                try {
                	String originalFilename = mfile[i].getOriginalFilename();//原始的名称
                    //String starName=originalFilename.substring(0,originalFilename.lastIndexOf("."));//文件名称不包括扩展名
                    String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                    String filePath = request.getSession().getServletContext()
                            .getRealPath("/") + "product/resource/" +start+ "."+suffix;//mfile[i].getOriginalFilename();
                    if(suffix.endsWith("wav")){
                    	scenicspotWav = start+ "."+suffix;
                    }else{
                    	scenicspotBg = start+ "."+suffix;
                    }
                    //转存文件

                    mfile[i].transferTo(new File(filePath));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
		}
		

		Product product = new Product();
		product.setQrcodeId(id);
		product.setScenicspotName(scenicspotName);
		product.setScenicspotWav(scenicspotWav);
		product.setScenicspotBg(scenicspotBg);
		long start = System.currentTimeMillis();
		product.setScenicspotLink(start+".html");
		//这里要创建一个html文件，先读取模板的内容，然后再替换其中的关键词
		//读取模板
		FileInputStream is = new FileInputStream(request.getSession().getServletContext().getRealPath("/")+"product/model.html");
		BufferedReader br  = new BufferedReader(new InputStreamReader(is));
		String str="";
		String tempStr = "";
		while ((tempStr = br.readLine()) != null)
             str = str + tempStr + "\n";
        is.close();
        //替换模板中的背景和声音
        str = str.replaceAll("resource/feng.png", "resource/"+scenicspotBg);
        str = str.replaceAll("resource/0001.wav", "resource/"+scenicspotWav);
        //写入新的文件
        File f = new File(request.getSession().getServletContext().getRealPath("/")+"product/"+start+".html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(str);
        bw.close();
        product.setScenicspotLinkContent(str);
		productService.createProduct(product);;
		return "redirect:/productController/list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpSession session,HttpServletRequest request) {
		String id = request.getParameter("id");
		Product product = productService.findProductById(id);
		try {
			productService.deleteProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/productController/list";
	}
	
	@RequestMapping("/modify")
	public String modify(HttpSession session,HttpServletRequest request) {
		return "redirect:/productController/list";
	}
	
	@RequestMapping("/modifyPage")
	public String modifyPage(HttpSession session,HttpServletRequest request) {
		return "product/qrcode_modify";
	}
	
	@RequestMapping("/export_png")
	public String export_png(HttpSession session, HttpServletRequest request,HttpServletResponse response) {
		try{
			String id = request.getParameter("id");
			Product product = productService.findProductById(id);
			
			String filename = product.getScenicspotLink();
			String filename_tmp = product.getScenicspotName()+"二维码图片";
			String filename2 = new String(filename_tmp.getBytes(),"ISO-8859-1");
			//需要在上方中间的位置加入标题
			
			response.setContentType("image/png; charset=utf-8");   
			response.setHeader("content-disposition", "attachment;filename="+filename2+".png");
			response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
			OutputStream out=response.getOutputStream();
			String path = session.getServletContext().getRealPath("/")+"product\\";
			String aaa = path+filename.substring(0,filename.indexOf("."))+".png";
				FileInputStream fileInputStream = new FileInputStream(aaa);  
	            BufferedInputStream bufferedInputStream = new BufferedInputStream(  
	                    fileInputStream);  
	            byte[] b = new byte[bufferedInputStream.available()];  
	            bufferedInputStream.read(b);  
				
				out.write(b);
				bufferedInputStream.close();
			
			out.flush();
			out.close();
		}catch(FileNotFoundException e){
			
		}catch(IOException e){
			
		}catch(Exception e){
			
		}

		return null;
	}
}
