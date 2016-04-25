package com.aw.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.jgroups.GetStateEvent;

import com.aw.bean.Cart;
import com.aw.bean.Goods;

public class GoodsDAO {
	
	public List<Goods> getGoodsByHql(String hql){
		List<Goods> glist=new ArrayList<Goods>();
		Session session = null;
		try{
			session = HibernateUtil.getSession();
			Transaction beginTransaction = session.beginTransaction();
			Query query = session.createQuery(hql);
			glist=query.list();
			beginTransaction.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return glist;	
	}
	
	
	//加入购物车
	public boolean addCart(Cart cart){
		try{
			Session session = HibernateUtil.getSession();
			Transaction beginTransaction = session.beginTransaction();
			session.save(cart);
			beginTransaction.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	//根据商品gid去删除购物车中的商品
	public boolean deleteCartByGid(String username,String gid){
		try{
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql = "delete Cart where gid = ? and username=?";
			int eu = session.createQuery(hql).setString(0, gid).setString(1, username).executeUpdate();
			transaction.commit();
			if(eu>0){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean deleteCartByDb_id(String ids){
		try{
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql ="delete from Cart where id in("+ids+")";
			int eu = session.createSQLQuery(hql).executeUpdate();
			transaction.commit();
			if(eu>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	//清空购物车额，就是人家下单之后清空他的购物车
	public boolean clearCartByUsername(String username){
		try{
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			String hql = "delete Cart where username=?";
			int eu = session.createQuery(hql).setString(0, username).executeUpdate();
			transaction.commit();
			if(eu>0){
				return true;
			}else{
				return false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	//查一下这个人购物车中的钱
	public double howmuchmoneyInCart(String username){
		try{
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			String hql = "SELECT SUM(price * count) AS total FROM Cart where username=?";
			double uniqueResult = (double) session.createSQLQuery(hql).setString(0, username).uniqueResult();
			transaction.commit();
			return uniqueResult;
			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	
	/**
		通过商品名和用户名查看是否该用户名购物车中有该商品
	 * @param name 商品名
	 * @param username 用户名
	 * @return 
	 */
	public Cart getCartByName(String name,String username){
		Session session = null;
		Transaction beginTransaction = null;
		try{
			session = HibernateUtil.getSession();
			beginTransaction = session.beginTransaction();
			Cart result = (Cart) session.createQuery("from Cart where name =? and username=?").setString(0, name).setString(1, username).uniqueResult();
			beginTransaction.commit();
			return result;
		}catch(Exception e){
			e.printStackTrace();
			beginTransaction.rollback();
			return null;
		}
	}
	
	//更新该用户的购物车中的商品+1
	
	public boolean updateCart(String name,String username){
		Session session = null;
		Transaction beginTransaction = null;
		try{
			session = HibernateUtil.getSession();
			beginTransaction = session.beginTransaction();
			String hql ="update Cart set count=count+1 where name=? and username=?";
			session.createSQLQuery(hql).setString(0, name).setString(1, username).executeUpdate();
			beginTransaction.commit();
			return true;
		}catch(Exception e ){
			e.printStackTrace();
			beginTransaction.rollback();
			return false;
		}
	}
	
	
	/**
	 * 根据用户名查购物车
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Cart> getCartByUsername(String username){
		Session session = null;
		Transaction beginTransaction = null;
		try{
			session = HibernateUtil.getSession();
			beginTransaction = session.beginTransaction();
			String hql ="from Cart where username=?";
			List<Cart> list = session.createQuery(hql).setString(0, username).list();
			beginTransaction.commit();
			return list;
		}catch(Exception e ){
			e.printStackTrace();
			beginTransaction.rollback();
			return null;
		}
	}
	
}
