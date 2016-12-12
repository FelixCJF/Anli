package com.jju.anli.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class User  implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;	  	
	private String username;			
	private String password;			
	private String salary;			
	private String birthday;			
	private String gender;			
	private String station;			
	private String telephone;			
	private String remark;			

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getSalary() {
		return this.salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}	
	
	public String getBirthday() {
		return this.birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}	
	
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}	
	
	public String getStation() {
		return this.station;
	}
	public void setStation(String station) {
		this.station = station;
	}	
	
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}	
	
	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}	
}
