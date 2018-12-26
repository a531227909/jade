package com.jade.service;

import com.jade.po.Result;

public interface ShoppingCartService {

	public Result selectShoppingCart(String account);
	
	public Result insertShoppingCart(String cid, String number, String account, String size, String color);
	
	public Result delShoppingCart(String id);
	
	public Result updateShoppingCart(String id, String cid, String number, String account);
}
