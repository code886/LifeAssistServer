package com.lifeAssist.user.action;

import java.io.File;
import java.net.URLDecoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.lifeAssist.core.action.BaseAction;
import com.lifeAssist.core.util.QueryHelper;
import com.lifeAssist.user.entity.User;
import com.lifeAssist.user.service.IUserService;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	@Resource
	private IUserService userService;
	
	private User user;
	private List<User> selected;
	
	//头像上传处理
	private File headImg;
	private String headImgFileName;
	private String headImgConentType;
	//登录结果
	private String loginResult;
	//
	private String strName;
	
	//列表页面
	public String listUI() throws Exception {
		QueryHelper queryHelper = new QueryHelper(User.class, "u");
		try {
			if(user!=null) {
				if(StringUtils.isNotBlank(user.getName())){
					strName = user.getName();
					System.out.println("====");
					user.setName(URLDecoder.decode(user.getName(),"utf-8"));
					queryHelper.addCondition("u.name like ?", "%"+user.getName()+"%");
				}
			}
			pageResult = userService.getPageResult(queryHelper, getPageNo(), getPageSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "listUI";
	}
	
	//跳转到新增页面
	public String addUI() {
		return "addUI";
	}
	
	//保存新增
	public String add() {
		try {
			if(user!=null) {
				if(headImg!=null) {
					//1.保存头像到upload/user
					//1.1获取路径的绝对地址
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString().replaceAll("-", "")
									+ headImgFileName.substring(headImgFileName.lastIndexOf("."));
					//1.2复制文件到指定路径
					FileUtils.copyFile(headImg, new File(filePath,fileName));
					//2.设置用户头像路径
					user.setHeadImg("user/"+fileName);
				}
				userService.save(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	//跳转到编辑页面
	public String editUI() {
		if(user!=null&&user.getId()!=null) {
			strName = user.getName();
			user = userService.findObjectById(user.getId());
		}
		return "editUI";
	}
	
	//保存编辑
	public String edit() {
		try {
			if(user!=null) {
				if(headImg!=null) {
					//1.保存头像到upload/user
					//1.1获取路径的绝对地址
					String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
					String fileName = UUID.randomUUID().toString().replaceAll("-", "")
									+ headImgFileName.substring(headImgFileName.lastIndexOf("."));
					//1.2复制文件到指定路径
					FileUtils.copyFile(headImg, new File(filePath,fileName));
					//2.设置用户头像路径
					user.setHeadImg("user/"+fileName);
				}
				userService.update(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	//删除
	public String delete() {
		if(user!=null&&user.getId()!=null) {
			userService.delete(user.getId());
		}
		return "list";
	}
	
	//批量删除
	public String deleteSelected() {
		if(selectedRow!=null) {
			for (String id : selectedRow) {
				userService.delete(id);
			}
		}
		return "list";
	}
	
	//帐号唯一性校验
	public void verifyAccount() {
		try {
			//1.获取帐号
			if(user!=null&&StringUtils.isNotBlank(user.getAccount())) {
				//2.根据帐号到数据库中校验是否存在
				List<User> list = userService.findUserByAccountAndId(user.getAccount(),user.getId());
				String strResult = "true";
				if(list!=null&&list.size()>0) {
					strResult = "false";
				}
				//输出
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html");
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(strResult.getBytes());
				outputStream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	public String getHeadImgConentType() {
		return headImgConentType;
	}

	public void setHeadImgConentType(String headImgConentType) {
		this.headImgConentType = headImgConentType;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public String getLoginResult() {
		return loginResult;
	}

	public void setLoginResult(String loginResult) {
		this.loginResult = loginResult;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}
	
}
