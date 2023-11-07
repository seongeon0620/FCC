package com.woori.myapp.entity;

import org.springframework.web.util.HtmlUtils;

//일반 DTO 필요한 필드가 있으면 추가한다 
public class Message {
	private Long mem_seq=0L;
	private String mem_name="";
	private String message="";
	private String mem_nickname="";   //JSON으로 만들어서 보낸다.
	private String roomid="all";
	
	@Override
	public String toString() {
		
		return HtmlUtils.htmlEscape(mem_nickname + " " + message + " " + roomid+ " "+roomid);
	}

	public Message()
	{}
	
	public Message(String username, String message, String userid, String roomid) {
		super();
		this.mem_name = mem_name;
		this.message = message;
		this.mem_nickname = mem_nickname;
		this.roomid=roomid;
	}

	public Long getMem_seq() {
		return mem_seq;
	}

	public void setMem_seq(Long mem_seq) {
		this.mem_seq = mem_seq;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMem_nickname() {
		return mem_nickname;
	}

	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	

	
	
	
}
