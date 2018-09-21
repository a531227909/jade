package com.jade.service;

import com.jade.po.Result;

public interface ShoppingCartService {

	public Result selectShoppingCart(String account);
	
	public Result insertShoppingCart(String cid,String account);
	
	public Result delShoppingCart(String id);
}
