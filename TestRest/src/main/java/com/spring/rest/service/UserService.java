package com.spring.rest.service;

import java.util.List;
import com.spring.rest.bean.UserBean;

public interface UserService 
{
	public boolean addUser(UserBean user);
	public UserBean updateUser(UserBean user);
	public UserBean getUser(int userId);
	public List<UserBean> getAllUser();
	public List<UserBean> deleteUser(int userId);


}
