package com.aw.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.aw.bean.Goods;
import com.aw.biz.GoodsBIZ;
import com.aw.dao.BillDAO;
import com.aw.dao.GoodsDAO;
import com.aw.entity.BillEntity;


public class TestData {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void howmuchmoneyInCart(){
		GoodsDAO gd = new GoodsDAO();
		double howmuchmoneyInCart = gd.howmuchmoneyInCart("123");
		System.out.println(howmuchmoneyInCart);
	}
	@Test
	public void deleteBYBdid(){
		GoodsDAO gd = new GoodsDAO();
		boolean deleteCartByDb_id = gd.deleteCartByDb_id("7,8");
		System.out.println(deleteCartByDb_id);
	}
	
	
	@Test
	public void testGoodDao(){
		GoodsBIZ gd = new GoodsBIZ();
		List<Goods> goodsPopList = gd.getGoodsPopList();
		for(Goods g : goodsPopList){
			System.out.println(g);
		}
	}
	
	
	@Test
	public void testBillDao(){
		BillDAO b = new BillDAO();
		List<BillEntity> billListByUid = b.getBillListByUid("123");
		System.out.println(billListByUid);
	}
	
	
	@Test
	public void testGoodByType(){
		GoodsBIZ gd = new GoodsBIZ();
		List<Goods> goodsListByType = gd.getGoodsListByType(1);
		for(Goods g : goodsListByType){
			System.out.println(g);
		}
	}
	
	
}
