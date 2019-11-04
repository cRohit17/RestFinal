package com.spring.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.bean.UserBean;
import com.spring.rest.dao.UserDao;
import com.spring.rest.entity.UserEntity;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	UserDao userDao;
	
	

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	static{
		System.out.println("Service impl loaded...");
	}
	
	//....................................................................
	
	private UserEntity convertToEntity(UserBean bean) {
		UserEntity entity=new UserEntity();
		entity.setUserId(bean.getUserId());
		entity.setUserName(bean.getUserName());
		entity.setMobile(bean.getMobile());
		entity.setEmail(bean.getEmail());
		
		return entity;
	}
	
	private UserBean convertToBean(UserEntity entity){
	    UserBean bean=new UserBean();
	    bean.setUserId(entity.getUserId());
	    bean.setUserName(entity.getUserName());
	    bean.setMobile(entity.getMobile());
	    bean.setEmail(entity.getEmail());
		return bean;
	}
	
	private List<UserBean> convertToBeans(List<UserEntity> entities){
		List<UserBean> beans = new ArrayList<UserBean>();
		for(UserEntity entity : entities)
		{
			beans.add(convertToBean(entity));
		}
		return beans;
	}
	
//.....................................................
	
	
	@Override
	public boolean addUser(UserBean user) {
		UserEntity entity=convertToEntity(user);
		return userDao.insertUser(entity);
	}

	@Override
	public UserBean updateUser(UserBean user) {
		return convertToBean(userDao.modifyUser(convertToEntity(user)));
	}

	@Override
	public UserBean getUser(int userId) {
		return convertToBean(userDao.fetchUser(userId));
	}

	@Override
	public List<UserBean> getAllUser() {
		return convertToBeans(userDao.fetchAllUser());
	}

	@Override
	public List<UserBean> deleteUser(int userId) {
		return convertToBeans(userDao.removeUser(userId));
	}

}
