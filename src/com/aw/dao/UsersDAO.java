package com.aw.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aw.bean.Users;

public class UsersDAO {
	
	public Users getUserByUid(String uid){
		Users user=null;
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql="from Users where uid='"+uid+"'";
			Query query = session.createQuery(hql);
			user=(Users)query.uniqueResult();
			transaction.commit();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return user;
	}
}
