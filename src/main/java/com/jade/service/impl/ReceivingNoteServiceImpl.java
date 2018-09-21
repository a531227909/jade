package com.jade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jade.dao.ReceivingNoteMapper;
import com.jade.mod.ReceivingNote;
import com.jade.mod.ReceivingNoteExample;
import com.jade.mod.ReceivingNoteExample.Criteria;
import com.jade.po.Result;
import com.jade.service.ReceivingNoteService;
import com.jade.uitil.UuidUtil;
@Service
public class ReceivingNoteServiceImpl implements ReceivingNoteService{

	@Autowired
	private ReceivingNoteMapper receivingNoteMapper;
	
	@Override
	public Result selectReceivingNote(String account) {
		Result result = new Result();
		try {
			ReceivingNoteExample example = new ReceivingNoteExample();
			Criteria criteria = example.createCriteria();
			criteria.andAccountEqualTo(account);
			List<ReceivingNote> list = receivingNoteMapper.selectByExample(example);
			result.setSuccess(true);
			result.getResult().put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result updatReceivingNote( String name,
			String telephone, String city, String address,String id) {
		
		Result result = new Result();
		try {
			ReceivingNote receivingNote = new ReceivingNote();
			
			receivingNote.setAddress(address);
			receivingNote.setCity(city);
			receivingNote.setName(name);
			receivingNote.setTelephone(telephone);
			ReceivingNoteExample example = new ReceivingNoteExample();
			Criteria criteria = example.createCriteria();
			criteria.andIdEqualTo(id);
			receivingNoteMapper.updateByExampleSelective(receivingNote, example);
			result.setSuccess(true);
			result.getResult().put("receivingNote", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result delReceivingNote(String id,String account) {
		Result result = new Result();
		try {
			ReceivingNote note = receivingNoteMapper.selectByPrimaryKey(id);
			if("0".equals(note.getrDefault())){
				receivingNoteMapper.deleteByPrimaryKey(id);
				result.setSuccess(true);
				result.getResult().put("receivingNote", "删除成功");
			}else{
				receivingNoteMapper.deleteByPrimaryKey(id);
				ReceivingNoteExample example = new ReceivingNoteExample();
				Criteria criteria = example.createCriteria();
				criteria.andAccountEqualTo(account);
				List<ReceivingNote> list = receivingNoteMapper.selectByExample(example);
				if(0<list.size()){
					list.get(0).setrDefault("1");
					receivingNoteMapper.updateByPrimaryKey(list.get(0));
				}
				result.setSuccess(true);
				result.getResult().put("receivingNote", "删除成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result selectReceivingNoteById(String id) {
	
			Result result = new Result();
			try {
				ReceivingNote note  = receivingNoteMapper.selectByPrimaryKey(id);
				result.setSuccess(true);
				result.getResult().put("data", note);
			} catch (Exception e) {
				e.printStackTrace();
				result.setSuccess(false);
				result.getResult().put("error", "error");
			}
			return result;
	}

	@Override
	public Result insertReceivingNote(String account, String name,
			String telephone, String city, String address) {
		Result result = new Result();
		try {
			ReceivingNote receivingNote = new ReceivingNote();
			receivingNote.setAccount(account);
			receivingNote.setAddress(address);
			receivingNote.setCity(city);
			receivingNote.setName(name);
			receivingNote.setTelephone(telephone);
			receivingNote.setId(UuidUtil.get32UUID());
			
			ReceivingNoteExample example = new ReceivingNoteExample();
			Criteria criteria = example.createCriteria();
			criteria.andRDefaultEqualTo("1");
			criteria.andRDefaultEqualTo(account);
			List<ReceivingNote> list = receivingNoteMapper.selectByExample(example);
			if(0<list.size()){
				receivingNote.setrDefault("1");
			}else{
				receivingNote.setrDefault("0");
			}
			receivingNoteMapper.insert(receivingNote);
			result.setSuccess(true);
			result.getResult().put("receivingNote", "添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result changeDefault(String id,String account) {
		Result result = new Result();
		try {
		
			ReceivingNoteExample example = new ReceivingNoteExample();
			Criteria criteria = example.createCriteria();
			criteria.andAccountEqualTo(id);
			List<ReceivingNote> list = receivingNoteMapper.selectByExample(example);
	
			for(int i=0;i<list.size();i++){
				list.get(i).setrDefault("0");
			
				receivingNoteMapper.updateByPrimaryKeySelective(list.get(i));
			}
		
			ReceivingNote receivingNote = new ReceivingNote();
			receivingNote.setrDefault("1");
			ReceivingNoteExample example1 = new ReceivingNoteExample();
			Criteria criteria1 = example1.createCriteria();
			criteria1.andIdEqualTo(account);
			receivingNoteMapper.updateByExampleSelective(receivingNote, example1);
			result.setSuccess(true);
			result.getResult().put("receivingNote", "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	@Override
	public Result selectByDefault(String account) {
		Result result = new Result();
		try {
			ReceivingNoteExample example = new ReceivingNoteExample();
			Criteria criteria = example.createCriteria();
			criteria.andRDefaultEqualTo("1");
			criteria.andAccountEqualTo(account);
			List<ReceivingNote> list = receivingNoteMapper.selectByExample(example);
			if(0<list.size()){
				result.setSuccess(true);
				result.getResult().put("data", list);
			}else{
				result.setSuccess(true);
				result.getResult().put("data", list);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.getResult().put("error", "error");
		}
		return result;
	}

	

}
