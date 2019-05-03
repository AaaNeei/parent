package com.yxw.base;

public class BaseResponse<T> {

	private Integer rtnCode;
	private String msg;
	private T data;

	public BaseResponse() {

	}

	public BaseResponse(Integer rtnCode, String msg, T data) {
		super();
		this.rtnCode = rtnCode;
		this.msg = msg;
		this.data = data;
	}

	public Integer getRtnCode() {
		return rtnCode;
	}

	public void setRtnCode(Integer rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}