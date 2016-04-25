package com.aw.biz;

import java.util.List;

import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.log4j.Logger;

import com.aw.bean.Cart;
import com.aw.bean.Goods;
import com.aw.dao.GoodsDAO;

public class GoodsBIZ {
	private Logger log = Logger.getLogger(GoodsBIZ.class);
	
	public List<Goods> getGoodsPopList(){
		String hql="from Goods where pop=1";
		List<Goods> glist=new GoodsDAO().getGoodsByHql(hql);
		return glist;
	}
	
	public List<Goods> getGoodsListByType(int type){
		String hql="from Goods where type="+type;
		
		List<Goods> glist=new GoodsDAO().getGoodsByHql(hql);
		return glist;
	}
	
	
	public boolean addCart(Cart cart){
		boolean result = false;
		
		String username = cart.getUsername();
		String name = cart.getName();
		log.info("商品的名称："+name+"  用户名："+username);
		
		GoodsDAO gd = new GoodsDAO();
		Cart cartByName = gd.getCartByName(name, username);
		log.info("加入到购物车中的商品:"+cartByName);
		
		if(null!=cartByName){//购物车中已有
			log.info("购物车中已有该商品");
			result = gd.updateCart(name, username);
		}else{
			result = gd.addCart(cart);
		}
		
		return result;
	}
	
	public double howmuchmoneyInCart(String username){
		GoodsDAO gd = new GoodsDAO();
		return gd.howmuchmoneyInCart(username);
	}
	
	public List<Cart> getCartByUsername(String username){
		GoodsDAO gd = new GoodsDAO();
		log.info("查看"+username+"的购物车");
		List<Cart> cartByUsername = gd.getCartByUsername(username);
		log.info("查看"+username+"的购物车-->"+cartByUsername);
		return cartByUsername;
	}
}
