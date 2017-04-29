package com.lifeAssist.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.lifeAssist.user.entity.User;
import com.lifeAssist.user.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class UserAction extends ActionSupport implements ServletResponseAware {

	private static final long serialVersionUID = 1L;
	
	private User user;
	private IUserService userService;
	private List<User> selected;
	private HttpServletResponse response;
	
	//登录
	public String login() throws IOException {
		User userInfo = userService.findUserByAccountAndPassword(user.getAccount(), user.getPassword());
		if(userInfo!=null) {
			JSONObject jsonObject = JSONObject.fromObject(userInfo);
			String json = jsonObject.toString();
			System.out.println(json);
			ActionContext.getContext().put("userInfo", userInfo);
			response.getWriter().write("userInfo："+json);
			return "loginSuccess";
		}else {
			return "loginFailed";
		}
	}
	
	public String register() throws IOException {
		User userInfo = userService.findUserByAccount(user.getAccount());
		if(userInfo!=null){
			response.getWriter().write("对不起，该账户已被注册！");
			return "registerFailed";
		}else {
			userService.save(user);
			ActionContext.getContext().put("userInfo", user);
			JSONObject jsonObject = JSONObject.fromObject(user);
			String json = jsonObject.toString();
			response.getWriter().write("userInfo:"+json);
			return "regiserSuccess";
		}
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public List<User> getSelected() {
		return selected;
	}
	public void setSelected(List<User> selected) {
		this.selected = selected;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}
