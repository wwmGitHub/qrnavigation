package com.jy.qrcodemake.security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecurityInterceptor  implements HandlerInterceptor{
	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);

	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
//		if (url.indexOf("/web/") > -1 || url.indexOf("/designer/") > -1)
//			return true;
//		// logger.info(url);
//		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
//		if (sessionInfo == null || sessionInfo.getId().equalsIgnoreCase("")) {// 如果没有登录或登录超时
//			request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
//			request.getRequestDispatcher("/webpage/error/noSession.jsp").forward(request, response);
//			return false;
//		}
//		if (url.indexOf("/baseController/") > -1 || url.indexOf("/supplierController/") > -1 || url.indexOf("/productionController/") > -1|| url.indexOf("/s/") > -1 || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
//			return true;
//		}

		
		
		
//		if(!sessionInfo.getIsLeader()){//非超级用户
//			boolean bFound = false;
//			for(String resource:sessionInfo.getResourceList()){
//				if(url.indexOf(resource)>0){
//					bFound = true;
//					break;
//				}
//			}
//			if (bFound) {
//				request.setAttribute("msg", "您没有访问此资源的权限！<br/>请联系超管赋予您<br/>[" + url + "]<br/>的资源访问权限！");
//				request.getRequestDispatcher("/jsp/error/noSecurity2.jsp").forward(request, response);
//				return false;
//			}
//		}
//		if (!sessionInfo.getResourceList().contains(url)) {// 如果当前用户没有访问此资源的权限
//			request.setAttribute("msg", "您没有访问此资源的权限！<br/>请联系超管赋予您<br/>[" + url + "]<br/>的资源访问权限！");
//			request.getRequestDispatcher("/jsp/error/noSecurity.jsp").forward(request, response);
//			return false;
//		}

		return true;
	}

}
