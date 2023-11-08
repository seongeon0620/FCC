package com.woori.myapp.entity;

import org.springframework.web.util.HtmlUtils;

//일반 DTO 필요한 필드가 있으면 추가한다 
public class Message {
	private String username="";
	private String message="";
	private String userid="";   //JSON으로 만들어서 보낸다.
	private String roomid="";
	
	@Override
	public String toString() {
		
		return HtmlUtils.htmlEscape(username + " " + message + " " + roomid+ " "+roomid);
	}

	public Message()
	{}
	
	public Message(String username, String message, String userid, String roomid) {
		super();
		this.username = username;
		this.message = message;
		this.userid = userid;
		this.roomid=roomid;
	}
	
	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
