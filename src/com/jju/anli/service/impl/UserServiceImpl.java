package com.jju.anli.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jju.anli.dao.IUserDao;
import com.jju.anli.domain.User;
import com.jju.anli.service.IUserService;
import com.jju.anli.utils.MD5Utils;
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User login(User model) {
		//获取密码，并使用MD5加密
		String password = model.getPassword();
		password = MD5Utils.md5(password);
		User user = userDao.findByUsernameAndPassword(model.getUsername(),password);
		return user;
	}

	@Override
	public void editPassword(String password, String id) {
		password = MD5Utils.md5(password);
		userDao.executeUpdate("editPassword",password,id);
	}

}
