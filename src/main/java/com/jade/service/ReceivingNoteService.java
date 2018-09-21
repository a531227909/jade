package com.jade.service;

import com.jade.po.Result;

public interface ReceivingNoteService {

	public Result selectReceivingNote(String account);
	
	public Result selectReceivingNoteById(String id);
	
	public Result insertReceivingNote(String account,String name,String telephone,String city,String address);
	
	public Result updatReceivingNote(String name,String telephone,String city,String address,String id);
	
	public Result delReceivingNote(String id,String account);
	
	public Result changeDefault(String id,String account);
	
	public Result selectByDefault(String account);
}
