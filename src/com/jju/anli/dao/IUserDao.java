package com.jju.anli.dao;

import com.jju.anli.domain.User;

public interface IUserDao extends IBaseDao<User> {

	User findByUsernameAndPassword(String username, String password);

}
