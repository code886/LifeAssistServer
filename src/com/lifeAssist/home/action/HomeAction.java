package com.lifeAssist.home.action;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public String execute() {
		return "home";
	}
	
	public String frame() {
		return "frame";
	}

	public String top() {
		return "top";
	}

	public String left() {
		return "left";
	}
	
}
