package com.blogprojectIO.exceptions;


//create a custom response for the API
public class ApiResponse {

	private String msg;
	private boolean success;
	
	public ApiResponse() {
		super();
	}
	public ApiResponse(String msg, boolean success) {
		this.msg = msg;
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	
}
