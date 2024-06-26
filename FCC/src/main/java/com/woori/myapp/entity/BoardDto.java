package com.woori.myapp.entity;

import com.woori.myapp.common.BaseDto;

public class BoardDto extends BaseDto{
	private Long board_seq;
    private String board_category="";
    private String board_title="";
    private String board_contents="";
    private String board_ingredients="";
    private	String board_wdate="";
    private Long member_seq;
    private String mem_nickname;
    private int cmt_cnt;
	public Long getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(Long board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_category() {
		return board_category;
	}
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_contents() {
		return board_contents;
	}
	public void setBoard_contents(String board_contents) {
		this.board_contents = board_contents;
	}
	public String getBoard_ingredients() {
		return board_ingredients;
	}
	public void setBoard_ingredients(String board_ingredients) {
		this.board_ingredients = board_ingredients;
	}
	public String getBoard_wdate() {
		return board_wdate;
	}
	public void setBoard_wdate(String board_wdate) {
		this.board_wdate = board_wdate;
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
	public int getCmt_cnt() {
		return cmt_cnt;
	}
	public void setCmt_cnt(int cmt_cnt) {
		this.cmt_cnt = cmt_cnt;
	}
    
	
	
}
