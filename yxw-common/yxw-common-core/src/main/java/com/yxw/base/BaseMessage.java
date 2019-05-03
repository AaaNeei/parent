package com.yxw.base;

public class BaseMessage {

	/**
	 * 开发者微信
	 */
	private String ToUserName;
	/**
	 * 发送方openid
	 */
	private String FromUserName;
	/**
	 * 创建时间
	 */
	private long CreateTime;
	/**
	 * 内容类型
	 */
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	// /**
	// * 消息id
	// */
	// private long MsgId ;
}
