package com.woori.myapp.entity;

import com.woori.myapp.common.BaseDto;

public class BoardDto extends BaseDto{
	private Long board_seq;
    private String board_category;
    private String board_title;
    private String board_contents;
    private String board_ingredients;
    private	String board_wdate;
    private Long member_seq;

    public Long getBoardSeq() {
        return board_seq;
    }

    public void setBoardSeq(Long boardSeq) {
        this.board_seq = boardSeq;
    }

    public String getBoardCategory() {
        return board_category;
    }

    public void setBoardCategory(String boardCategory) {
        this.board_category = boardCategory;
    }

    public String getBoardTitle() {
        return board_title;
    }

    public void setBoardTitle(String boardTitle) {
        this.board_title = boardTitle;
    }

    public String getBoardContents() {
        return board_contents;
    }

    public void setBoardContents(String boardContents) {
        this.board_contents = boardContents;
    }

    public String getBoardIngredients() {
        return board_ingredients;
    }

    public void setBoardIngredients(String boardIngredients) {
        this.board_ingredients = boardIngredients;
    }

    public String getBoardWDate() {
        return board_wdate;
    }

    public void setBoardWDate(String boardWDate) {
        this.board_wdate = boardWDate;
    }

    public Long getMemberSeq() {
        return member_seq;
    }

    public void setMemberSeq(Long memberSeq) {
        this.member_seq = memberSeq;
    }
}
