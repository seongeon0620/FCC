package com.woori.myapp.entity;

public class MemberDto {

	 private Long member_seq=0L;
	 private String user_name=""; 
	 private String password=""; 
	 private String email=""; 
	 private String nick_name="";
	 private String member_wdate="";
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MemberDto(Long member_seq, String user_name, String password, String email, String nick_name,
			String member_wdate) {
		super();
		this.member_seq = member_seq;
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.nick_name = nick_name;
		this.member_wdate = member_wdate;
	}
	
	public Long getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(Long member_seq) {
		this.member_seq = member_seq;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getMember_wdate() {
		return member_wdate;
	}
	public void setMember_wdate(String member_wdate) {
		this.member_wdate = member_wdate;
	}
	 
	
	
}
