package com.jju.anli.service;

import com.jju.anli.domain.User;

public interface IUserService {
	public User login(User model);

	public void editPassword(String password, String id);

}
