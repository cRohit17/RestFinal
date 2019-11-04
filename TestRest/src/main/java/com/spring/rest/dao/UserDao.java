package com.spring.rest.dao;

import java.util.List;

import com.spring.rest.entity.UserEntity;


public interface UserDao 
{
	public boolean insertUser(UserEntity user);
	public UserEntity modifyUser(UserEntity user);
	public UserEntity fetchUser(int userId);
	public List<UserEntity> fetchAllUser();
	public List<UserEntity> removeUser(int userId);


}
