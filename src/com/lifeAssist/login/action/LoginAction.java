package com.lifeAssist.login.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.lifeAssist.core.constant.Constants;
import com.lifeAssist.user.entity.User;
import com.lifeAssist.user.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	@Resource
	private IUserService userService;
	
	private User user;
	private String loginResult;
	
	public String loginUI() {
		return "loginUI";
	}

	public String login() {
		if(user!=null) {
			if(StringUtils.isNotBlank(user.getAccount())&&StringUtils.isNotBlank(user.getPassword())) {
				//根据帐号密码查询用户
				List<User> list = userService.findUserByAccountAndPassword(user.getAccount(),user.getPassword());
				if(list!=null&&list.size()==1) {
					//登录成功
					user = list.get(0);
					ServletActionContext.getRequest().getSession().setAttribute(Constants.USER, user);
					Log log = LogFactory.getLog(getClass());
					log.info("用户名为："+user.getName()+"登录了系统");
					return "home";
				}else {
					//登录失败
					loginResult = "帐号或密码不正确！";
				}
			}else {
				loginResult = "帐号或密码不能为空！";
			}
		}else {
			loginResult = "请输入帐号和密码！";
		}
		return loginUI();
	}

	//退出，注销
	public String logout(){
		//清除session中保存的用户信息
		ServletActionContext.getRequest().getSession().removeAttribute(Constants.USER);
		return loginUI();
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginResult() {
		return loginResult;
	}
	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}
}
