package com.jy.qrcodemake.web.controller;

import com.jy.qrcodemake.entity.User;
import com.jy.qrcodemake.model.Json;
import com.jy.qrcodemake.model.UserModel;
import com.jy.qrcodemake.service.ProductServiceI;
import com.jy.qrcodemake.service.UserServiceI;
import com.jy.qrcodemake.util.GlobalFunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
     * 用户创建(注册)操作
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpSession session){
        //获取表单中用户创建信息
        String userLoginName = GlobalFunc.toString(request.getParameter("userLoginName"));
        String userLoginPass = GlobalFunc.toString(request.getParameter("userLoginPass"));
        //-------------
        if (userLoginName!=null&&userLoginName!=""&&userLoginPass!=null&&userLoginPass!="") {
            //封装数据到userModel
            User user = new User();
            user.setUserLoginName(userLoginName);
            user.setUserLoginPass(userLoginPass);
            userService.creatUser(user);
        }

        //System.out.println("debugger调试用");

        //跳转到系统登陆之后的页面
        //TODO  用户创建 景区信息页面
        return "XXXXXX";
    }

    /**
     * 获取账户list
     * @return
     */
    @ResponseBody
    @RequestMapping("/getuserlist")
    public List<UserModel> getUserList(){
        List<UserModel> userList = userService.getUserList();
        return userList;
    }

}
