package com.aw.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.aw.bean.Cart;
import com.aw.bean.Goods;
import com.aw.biz.GoodsBIZ;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport{
	
	private Logger log = Logger.getLogger(GoodsAction.class);
	List<Goods> glist;
	private double howmuchmoneyInCart ;
	public double getHowmuchmoneyInCart() {
		return howmuchmoneyInCart;
	}
	public void setHowmuchmoneyInCart(double howmuchmoneyInCart) {
		this.howmuchmoneyInCart = howmuchmoneyInCart;
	}
	
	
	private List<Cart> cartList;
	
	public List<Cart> getCartList() {
		return cartList;
	}
	
	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
	
	
	private Cart cart;
	private String username;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	public String execute() throws Exception {	
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String type=request.getParameter("type");
		if(type.equals("pop")){
			this.setGlist(new GoodsBIZ().getGoodsPopList());
		}
		else if(type.equals("type")){
			int gtype=Integer.valueOf(request.getParameter("gtype"));
			this.setGlist(new GoodsBIZ().getGoodsListByType(gtype));
		}
		return SUCCESS;
	}
	
	
	public String addCart(){
		boolean addCart = new GoodsBIZ().addCart(cart);
		if(addCart){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	
	public String getCartByUsername(){
		List<Cart> cartByUsername = new GoodsBIZ().getCartByUsername(username);
		this.setCartList(cartByUsername);
		return SUCCESS;
	}
	
	public String howmuchmoneyInCart(){
		howmuchmoneyInCart = new GoodsBIZ().howmuchmoneyInCart(username);
		return SUCCESS;
	}
	
	public List<Goods> getGlist() {
		return glist;
	}

	public void setGlist(List<Goods> glist) {
		this.glist = glist;
	}
	
	
}
