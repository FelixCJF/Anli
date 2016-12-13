package com.jju.anli.web.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jju.anli.domain.User;
import com.jju.anli.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	//提供属性接收验证码
	String checkcode;
	

	
	@Resource
	private IUserService userService;
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		//从session中获得自动生成的验证码
		String key = (String) ActionContext.getContext().getSession().get("key");
		if (StringUtils.isNotBlank(checkcode) && checkcode.equals(key)) {
			//验证码正确
			User user = userService.login(model);
			if (user != null) {
				//登录成功
				ActionContext.getContext().getSession().put("loginUser", user);
				return "home";
			}else {
				//登录失败，添加错误信息，跳转到登陆页面
				this.addActionError(this.getText("loginError"));
				return "login";
			}
		}else{
			//验证码有误,添加错误信息，跳转到登录页面
			this.addActionError(this.getText("checkcodeError"));
			return "login";
		}
	}
	
	/**
	 * 修改密码
	 * @throws IOException 
	 */
	public String editPassword() throws IOException{
		String password = model.getPassword();
		User user = (User) ActionContext.getContext().getSession().get("loginUser");
		String id = user.getId();
		String flag = "1";
		try {
			userService.editPassword(password,id);
		} catch (Exception e) {
			flag = "0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(flag);
		return NONE;
	}
	
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

}






