package com.yxw.base;

import lombok.Data;

@Data
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

}