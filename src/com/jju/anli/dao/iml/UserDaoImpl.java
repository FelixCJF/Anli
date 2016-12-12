package com.jju.anli.dao.iml;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jju.anli.dao.IUserDao;
import com.jju.anli.domain.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {


	/**
	 * 根据用户名和密码查询
	 */
	public User findByUsernameAndPassword(String username, String password) {
		String hql = "FROM User u WHERE u.username=? AND u.password=?";
		List<User> list = this.getHibernateTemplate().find(hql, username,password);
		if (list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
