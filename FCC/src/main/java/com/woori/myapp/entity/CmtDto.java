package com.woori.myapp.entity;

public class CmtDto {
	private Long cmt_seq;
	private String cmt_contents;
	private String cmt_wdate;
	private Long board_seq;
	private Long member_seq;
	private String mem_nickname = "";
	private String mem_img = "";
	private Long mem_imgsize = 0L;
	private String myCmt;

	public Long getCmt_seq() {
		return cmt_seq;
	}
	public void setCmt_seq(Long cmt_seq) {
		this.cmt_seq = cmt_seq;
	}
	public String getCmt_contents() {
		return cmt_contents;
	}
	public void setCmt_contents(String cmt_contents) {
		this.cmt_contents = cmt_contents;
	}
	public String getCmt_wdate() {
		return cmt_wdate;
	}
	public void setCmt_wdate(String cmt_wdate) {
		this.cmt_wdate = cmt_wdate;
	}
	public Long getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(Long board_seq) {
		this.board_seq = board_seq;
	}
	public Long getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(Long member_seq) {
		this.member_seq = member_seq;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
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
	public String getMyCmt() {
		return myCmt;
	}
	public void setMyCmt(String myCmt) {
		this.myCmt = myCmt;
	}
	

	
	
	
	
	
	
	
}
