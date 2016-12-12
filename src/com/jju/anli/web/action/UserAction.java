package com.jju.anli.web.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jju.anli.domain.User;
import com.jju.anli.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	//提供属性接收验证码
	String checkCode;
	
	@Resource
	private IUserService useService;
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		//从session中获得自动生成的验证码
		String key = (String) ActionContext.getContext().getSession().get("");
		if (StringUtils.isNotBlank(checkCode) && checkCode.equals(key)) {
			//验证码正确
			User user = useService.login(model);
			if (user != null) {
				//登录成功
				ActionContext.getContext().getSession().put("loginUser", user);
				return "home";
			}else {
				//登录失败，添加错误信息，跳转到登陆页面
				this.addActionError(this.getText("loginError"));
				return "login";
			}
		}
		return null;
		
	}

}






