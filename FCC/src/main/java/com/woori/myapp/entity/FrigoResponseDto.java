package com.woori.myapp.entity;

import org.springframework.stereotype.Repository;

public class FrigoResponseDto {
	private Long frigo_seq;
	private String ingre_name;
	private String ingre_detail;
	private String frigo_expiration;
	private String frigo_wdate;
	private String frigo_storage;
	private String ddayBadge;
	private Long mem_seq;
	public FrigoResponseDto() {}
	
	
	public FrigoResponseDto(Long frigo_seq, String ingre_name, String ingre_detail, String frigo_expiration,
			String frigo_wdate, String frigo_storage, String ddayBadge, Long mem_seq) {
		super();
		this.frigo_seq = frigo_seq;
		this.ingre_name = ingre_name;
		this.ingre_detail = ingre_detail;
		this.frigo_expiration = frigo_expiration;
		this.frigo_wdate = frigo_wdate;
		this.frigo_storage = frigo_storage;
		this.ddayBadge = ddayBadge;
		this.mem_seq = mem_seq;
	}


	public Long getMem_seq() {
		return mem_seq;
	}


	public void setMem_seq(Long mem_seq) {
		this.mem_seq = mem_seq;
	}


	public Long getFrigo_seq() {
		return frigo_seq;
	}
	public void setFrigo_seq(Long frigo_seq) {
		this.frigo_seq = frigo_seq;
	}
	public String getIngre_name() {
		return ingre_name;
	}
	public void setIngre_name(String ingre_name) {
		this.ingre_name = ingre_name;
	}
	public String getIngre_detail() {
		return ingre_detail;
	}
	public void setIngre_detail(String ingre_detail) {
		this.ingre_detail = ingre_detail;
	}
	public String getFrigo_expiration() {
		return frigo_expiration;
	}
	public void setFrigo_expiration(String frigo_expiration) {
		this.frigo_expiration = frigo_expiration;
	}
	public String getFrigo_wdate() {
		return frigo_wdate;
	}
	public void setFrigo_wdate(String frigo_wdate) {
		this.frigo_wdate = frigo_wdate;
	}
	public String getFrigo_storage() {
		return frigo_storage;
	}
	public void setFrigo_storage(String frigo_storage) {
		this.frigo_storage = frigo_storage;
	}
	public String getDdayBadge() {
		return ddayBadge;
	}
	public void setDdayBadge(String ddayBadge) {
		this.ddayBadge = ddayBadge;
	}
}
