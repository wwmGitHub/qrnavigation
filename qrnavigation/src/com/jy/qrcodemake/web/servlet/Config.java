package com.jy.qrcodemake.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.qrcodemake.web.WebInit;

public class Config  extends HttpServlet{
	public HttpServletRequest request = null;
	public static String DB_TYPE = "MSSQLSERVER";

	public void doGet(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse) throws ServletException,
			IOException {
		this.request = httpservletrequest;
	}

	public void init() throws ServletException {
		System.out.println("**************开始初始化***************");
		new WebInit();
	}
	
	public void doPost(HttpServletRequest httpservletrequest,
			HttpServletResponse httpservletresponse) throws ServletException,
			IOException {
		this.request = httpservletrequest;
	}
}
