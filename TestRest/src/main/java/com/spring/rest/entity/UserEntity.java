package com.spring.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserEntity 
{
	@Id
	private int userId;
	private String userName;
	private int mobile;
	private String email;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", mobile=" + mobile + ", email=" + email
				+ "]";
	}
	public UserEntity(int userId, String userName, int mobile, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
