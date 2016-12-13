package com.jju.anli.dao;

import java.util.List;

public interface IBaseDao<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(String id);
	public List<T> findAll();
	public void executeUpdate(String queryName,Object...args);
}
