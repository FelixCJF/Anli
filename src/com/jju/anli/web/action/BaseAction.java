package com.jju.anli.web.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	T model;//模型对象
	
	@Override
	public T getModel() {
		return model;
	}
	
	//获得实体类型，通过反射获得模型对象
	public BaseAction() {
		//获得父类（BaseAction）类型
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得父类的泛型数组
		Type[] typeArguments = superclass.getActualTypeArguments();
		//得到实体
		Class<T> domainClass = (Class<T>) typeArguments[0];
		
		try {
			model = domainClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
