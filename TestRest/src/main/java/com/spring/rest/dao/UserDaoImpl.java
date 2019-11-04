package com.spring.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.entity.UserEntity;
import com.spring.rest.util.SessionFactoryUtil;

@Repository
public class UserDaoImpl implements UserDao 
{
	@Autowired
	SessionFactory sFactory;
	
	
	
	public SessionFactory getsFactory() {
		return sFactory;
	}

	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}

	static{	System.out.println("Product DaoImpl loaded...");	}
	

	//................................................................................
	
	@Override
	public boolean insertUser(UserEntity user) {
		Session session = null;
		Transaction tr = null;
		try {
			session = sFactory.openSession();
			tr = session.beginTransaction();
			session.save(user);
			return true;
		} catch (Exception e) {
			System.out.println("Insertion failed..."+e.getMessage());

		} finally {
			SessionFactoryUtil.closeResources(session, tr);
		}
		return false;
	}

	@Override
	public UserEntity modifyUser(UserEntity user) {
		Session session=null;
		Transaction tr=null;
		UserEntity userdb=fetchUser(user.getUserId());
		if(userdb!=null){
			try{
			session=sFactory.openSession();
			tr=session.beginTransaction();
			return (UserEntity) session.merge(user);
			}catch(Exception e){
				System.out.println("Update product failed...");
			}finally{
				SessionFactoryUtil.closeResources(session, tr);
			}
		}
		return null;
	}

	@Override
	public UserEntity fetchUser(int userId) {
		Session session=null;
		try{
			session=sFactory.openSession();
	        return session.get(UserEntity.class,userId);		
		}catch(Exception e){
			System.out.println("Fetch product failed...");
		}finally{
			SessionFactoryUtil.closeResources(session,null);
		}
		return null;
	}

	@Override
	public List<UserEntity> fetchAllUser() {
		Session session=null;
		try{
			session=sFactory.openSession();
			return session.createCriteria(UserEntity.class).list();
		}catch(Exception e){
		    System.out.println("Fetch all product failed...");
		}finally{
			SessionFactoryUtil.closeResources(session, null);
		}
		return null;
	}

	@Override
	public List<UserEntity> removeUser(int userId) {
		Session session=null;
		Transaction tr=null;
		UserEntity userDb=fetchUser(userId);
		if(userDb!=null){
			try{
				session=sFactory.openSession();
				tr=session.beginTransaction();
				session.remove(userDb);
			}catch(Exception e){
				System.out.println("Remove product failed...");
			}finally{
				SessionFactoryUtil.closeResources(session, tr);
			}
		}
		return fetchAllUser();
	}
}
