package com.woori.myapp.entity;

public class MemberDto {

	 private Long mem_seq=0L;
	 private String mem_name=""; 
	 private String mem_password=""; 
	 private String mem_email=""; 
	 private String mem_nickname="";
	 private String member_wdate="";
	 private String mem_img="";
	 private Long mem_imgsize=0L;
	 
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberDto(Long member_seq, String mem_name, String mem_password, String mem_email, String mem_nickname,
			String member_wdate, String mem_img, Long mem_imgsize) {
		super();
		this.mem_seq = member_seq;
		this.mem_name = mem_name;
		this.mem_password = mem_password;
		this.mem_email = mem_email;
		this.mem_nickname = mem_nickname;
		this.member_wdate = member_wdate;
		this.mem_img = mem_img;
		this.mem_imgsize = mem_imgsize;
	}

	public Long getMember_seq() {
		return mem_seq;
	}

	public void setMember_seq(Long member_seq) {
		this.mem_seq = member_seq;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_password() {
		return mem_password;
	}

	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_nickname() {
		return mem_nickname;
	}

	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}

	public String getMember_wdate() {
		return member_wdate;
	}

	public void setMember_wdate(String member_wdate) {
		this.member_wdate = member_wdate;
	}

	public String getMem_img() {
		return mem_img;
	}

	public void setMem_img(String mem_img) {
		this.mem_img = mem_img;
	}

	public Long getMem_imgsize() {
		return mem_imgsize;
	}

	public void setMem_imgsize(Long mem_imgsize) {
		this.mem_imgsize = mem_imgsize;
	}
	
	
	 
	
	
}
