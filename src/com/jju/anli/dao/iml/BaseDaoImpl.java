package com.jju.anli.dao.iml;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jju.anli.dao.IBaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	//实体类型
	Class<T> entityClass;
	
	//注入SessionFactory对象
	@Resource
	public void setSF(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	//从构造方法中获得实体
	public BaseDaoImpl() {
		//获得父类的(BaseDaoImpl)类型
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得泛型类型数组
		Type[] types = superclass.getActualTypeArguments();
		//获得实体类型
		entityClass = (Class<T>) types[0];
		
	}
	
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
