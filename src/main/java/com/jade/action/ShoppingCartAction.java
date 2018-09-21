package com.jade.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.ShoppingCartService;

@Controller
@RequestMapping(value="shoppingCart")
public class ShoppingCartAction {

	@Autowired
	private ShoppingCartService shoppingCartService;
	/**
	 * 根据用户账号查询所有购物车信息
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/selectShoppingCart.action",method=RequestMethod.POST)
	public @ResponseBody Result selectShoppingCart(HttpSession session) {
		String account = (String) session.getAttribute("account");
		return shoppingCartService.selectShoppingCart(account);
	}
	/**
	 * 添加购物车
	 * @param cid
	 * @param sid
	 * @param name
	 * @param price
	 * @param color
	 * @param number
	 * @param img
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/insertShoppingCart.action",method=RequestMethod.POST)
	public @ResponseBody Result insertShoppingCart(String cid,
			HttpSession session) {
		String account = (String) session.getAttribute("account");
		return shoppingCartService.insertShoppingCart(cid,  account);
	}
	/**
	 * 删除购物车
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delShoppingCart.action",method=RequestMethod.POST)
	public @ResponseBody Result delShoppingCart(String id) {
		return shoppingCartService.delShoppingCart(id);
	}
}
