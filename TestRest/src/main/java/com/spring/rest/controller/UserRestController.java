package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.bean.UserBean;
import com.spring.rest.service.UserService;

@RestController
@RequestMapping(value="/rest")
public class UserRestController 
{
	@Autowired
	UserService userService;
	
	static{
		System.out.println("Inside controller..");
	}
	
	

	@RequestMapping(value="/add", method = RequestMethod.POST)
	public String addUser(@RequestBody UserBean userBean)
	{
		this.userService.addUser(userBean);
		return userBean.getUserName()+" user added suceesfully..";
	
	}
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public List<UserBean> editUser(@PathVariable("id") int id,@RequestBody UserBean userBean) {
		this.userService.updateUser(userBean);
		return userService.getAllUser();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public UserBean getUser(@PathVariable("id") int id)
	{
		return this.userService.getUser(id);
		
	}

	@RequestMapping(value="/get",method=RequestMethod.GET)
	public List<UserBean> listUsers(){
		return this.userService.getAllUser();
		
	}
	

	@RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
    public String removeUser(@PathVariable("userId") int userId){
        this.userService.deleteUser(userId);
        return "Delete user successfully";
    }
	
	

}
