package com.spring.rest.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionFactoryUtil 
{
	// My comment 1 here.
	// My comment 3 here.
	// My comment 2 here.
	// My comment 4 here.
	public static void closeResources(Session session,Transaction tr){
		try{
			if(session!=null){
				if(tr!=null){
				session.flush();
				tr.commit();
				}
				session.close();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
