package com.jade.po;

import java.util.HashMap;
import java.util.Map;

public class Result {

	private boolean success = false;
	private Map<String, Object>result = new HashMap<String, Object>();
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
