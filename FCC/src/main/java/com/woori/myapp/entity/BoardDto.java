package com.woori.myapp.entity;

public class BoardDto {
	private Long boardSeq;
    private String boardWriter;
    private String boardCategory;
    private String boardTitle;
    private String boardContents;
    private String boardIngredients;
    private	String boardWDate;
    private Long memberSeq;

    public Long getBoardSeq() {
        return boardSeq;
    }

    public void setBoardSeq(Long boardSeq) {
        this.boardSeq = boardSeq;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public String getBoardCategory() {
        return boardCategory;
    }

    public void setBoardCategory(String boardCategory) {
        this.boardCategory = boardCategory;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getBoardIngredients() {
        return boardIngredients;
    }

    public void setBoardIngredients(String boardIngredients) {
        this.boardIngredients = boardIngredients;
    }

    public String getBoardWDate() {
        return boardWDate;
    }

    public void setBoardWDate(String boardWDate) {
        this.boardWDate = boardWDate;
    }

    public Long getMemberSeq() {
        return memberSeq;
    }

    public void setMemberSeq(Long memberSeq) {
        this.memberSeq = memberSeq;
    }
}
