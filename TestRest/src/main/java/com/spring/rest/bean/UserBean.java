package com.spring.rest.bean;

public class UserBean 
{
	private int userId;
	private String userName;
	private String mobile;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
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
		return "UserBean [userId=" + userId + ", userName=" + userName + ", mobile=" + mobile + ", email=" + email
				+ "]";
	}
	public UserBean(int userId, String userName, String mobile, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.mobile = mobile;
		this.email = email;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
