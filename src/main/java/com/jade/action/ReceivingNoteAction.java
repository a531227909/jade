package com.jade.action;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jade.po.Result;
import com.jade.service.ReceivingNoteService;

@Controller
@RequestMapping(value="receivingNote")
public class ReceivingNoteAction {

	@Autowired
	private ReceivingNoteService receivingNoteSrevice;
	/**
	 * 获取该用户的所有收货地址
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/selectReceivingNote.action",method=RequestMethod.POST)
	public @ResponseBody Result selectReceivingNote(HttpSession session) {
		String account = (String) session.getAttribute("account");
		return receivingNoteSrevice.selectReceivingNote(account);
		
	}
	/**
	 * 更新指定的收货地址
	 * @param account
	 * @return
	 */
	@RequestMapping(value="/updateReceivingNote.action",method=RequestMethod.POST)
	public @ResponseBody Result updatReceivingNote(String name,
			String telephone, String city, String address,String id) {
		return receivingNoteSrevice.updatReceivingNote(name,telephone,city,address,id);
		
	}
	/**
	 * 根据ID删除收货地址
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delReceivingNote.action",method=RequestMethod.POST)
	public @ResponseBody Result delReceivingNote(String id,HttpSession session) {
		String account = (String) session.getAttribute("account");
		return receivingNoteSrevice.delReceivingNote(id,account);
		
	}
	/**
	 * 根据ID查询收货地址信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/selectReceivingNoteById.action",method=RequestMethod.POST)
	public @ResponseBody Result selectReceivingNoteById(String id) {
		return receivingNoteSrevice.selectReceivingNoteById(id);
		
	}
	/**
	 * 插入一条新的收货地址
	 * @param account
	 * @param name
	 * @param telephone
	 * @param city
	 * @param address
	 * @return
	 */
	@RequestMapping(value="/insertReceivingNote.action",method=RequestMethod.POST)
	public @ResponseBody Result insertReceivingNote(HttpSession session,String name,
			String telephone, String city, String address) {
		String account = (String) session.getAttribute("account");
		return receivingNoteSrevice.insertReceivingNote(account,name,telephone,city,address);
		
	}
	/**
	 * 修改默认地址
	 * @param account
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/changeDefault.action",method=RequestMethod.POST)
	public @ResponseBody Result changeDefault(HttpSession session,String id) {
		String account = (String) session.getAttribute("account");
		return receivingNoteSrevice.changeDefault(account,id);
		
	}
	
	/**
	 * 获取默认地址
	 * @param account
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/selectByDefault.action",method=RequestMethod.POST)
	public @ResponseBody Result selectByDefault(HttpSession session) {
		String account = (String) session.getAttribute("account");
		return receivingNoteSrevice.selectByDefault(account);
		
	}

}
