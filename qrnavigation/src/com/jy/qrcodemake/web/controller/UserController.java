package com.jy.qrcodemake.web.controller;

import com.jy.qrcodemake.entity.User;
import com.jy.qrcodemake.model.Json;
import com.jy.qrcodemake.model.UserModel;
import com.jy.qrcodemake.service.ProductServiceI;
import com.jy.qrcodemake.service.UserServiceI;
import com.jy.qrcodemake.util.GlobalFunc;
import com.jy.qrcodemake.util.Unid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/userController")
public class UserController extends BaseController {
	@Autowired
	private ProductServiceI productService;
	@Autowired
	private UserServiceI userService;
	
	//用户登录操作
    @ResponseBody
	@RequestMapping("/login")
	public Json login(UserModel um,HttpSession session,HttpServletRequest request){
		String userLoginName = GlobalFunc.toString(request.getParameter("userLoginName"));
		String userLoginPass = GlobalFunc.toString(request.getParameter("userLoginPass"));
		UserModel u = userService.login(um);
		Json j = new Json();
		if(u!=null){
			
			j.setSuccess(true);
			j.setMsg("登陆成功！");
		}else{
			
			j.setSuccess(false);
			j.setMsg("用户名或密码不正确！");
		}
		
		return j;
	}
    //用户退出操作
	@ResponseBody
	@RequestMapping("/logout")
	public Json logout(HttpSession session,HttpServletRequest request) {
		if (session != null) {
			session.invalidate();
		}
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("退出成功！");
		return j;
	}

    /**
     * 获取账户list
     * @return
     */
    @RequestMapping("/getuserlist")
    public String getUserList(HttpServletRequest request, HttpSession session){
		String userLoginName = GlobalFunc.toString(session.getAttribute("userLoginName"));
		String userLoginPass = GlobalFunc.toString(session.getAttribute("userLoginPass"));
        List<UserModel> userList = userService.getUserList(userLoginName,userLoginPass);
		session.setAttribute("userList",userList);
        return "/product/qrcode_list";
    }

	/**
	 * 修改  find user
	 * @param request
	 * @param session
     * @return
     */
	@ResponseBody
	@RequestMapping("/finduser")
	public UserModel findUserById(HttpServletRequest request ,HttpSession session){
		String userId = request.getParameter("userId");
		UserModel userModel = userService.findUserById(userId,null,null,null);
		session.setAttribute("userModel",userModel);
		return userModel;
	}

	/**
	 * 创建用户
	 * 保存 修改之后的账号信息
	 * @param request
	 * @param session
	 * @param response
     * @return
     */
	@ResponseBody
	@RequestMapping("/saveuser")
	public Integer saveUser(HttpServletRequest request , HttpSession session, HttpServletResponse response){
		String userLoginName = GlobalFunc.toString(request.getParameter("userName"));
		String userLoginPass = GlobalFunc.toString(request.getParameter("userPassWord"));
		try {
			Integer integer = userService.saveUser(userLoginName, userLoginPass);
			return integer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * After the user information and qr code data are searched,
	 * user information and qr code data are displayed on the page
	 * 重定向 到二维码查询操作
	 * @param
	 * @param request
	 * @param response
	 * @param session
     * @return
     */
	@RequestMapping("/findcommonsuser")
	public String findUser(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String userLoginName = GlobalFunc.toString(request.getParameter("userLoginName"));
		String userLoginPass = GlobalFunc.toString(request.getParameter("userLoginPass"));
		UserModel userModel=userService.findUserById(null,null,userLoginName,userLoginPass);
		session.setAttribute("commonsUser",userModel);
		// 查找对应二维码操作
		return "redirect:/productController/productcode";
	}
}
