package com.lifeAssist.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lifeAssist.core.constant.Constants;
import com.lifeAssist.user.entity.User;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		System.out.println(uri);
		if(!uri.contains("sys/login_")) {
			//当前访问页不是登录页面
			User user = (User) request.getSession().getAttribute(Constants.USER);
			if(user!=null) {
				//有登录
				chain.doFilter(request, response);
			}else {
				//没有登录，跳转到登录界面
				response.sendRedirect(request.getContextPath()+"/sys/login_loginUI.action");
			}
		}else {
			//正在登录
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
