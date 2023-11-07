package com.woori.myapp.entity;

public class FrigoDto {
	private Long frigo_seq = 0L;
	private Long mem_seq = 0L;
	private String ingre_seq = "";
	private String frigo_expiration = "";
	private String frigo_storage = "";
	private String frigo_wdate = "";
	
	public FrigoDto() {}
	
	public FrigoDto(Long frigo_seq, Long mem_seq, String ingre_seq, String frigo_expiration, String frigo_storage,
			String frigo_wdate) {
		super();
		this.frigo_seq = frigo_seq;
		this.mem_seq = mem_seq;
		this.ingre_seq = ingre_seq;
		this.frigo_expiration = frigo_expiration;
		this.frigo_storage = frigo_storage;
		this.frigo_wdate = frigo_wdate;
	}
	public Long getFrigo_seq() {
		return frigo_seq;
	}
	public void setFrigo_seq(Long frigo_seq) {
		this.frigo_seq = frigo_seq;
	}
	public Long getMem_seq() {
		return mem_seq;
	}
	public void setMem_seq(Long mem_seq) {
		this.mem_seq = mem_seq;
	}
	public String getIngre_seq() {
		return ingre_seq;
	}
	public void setIngre_seq(String ingre_seq) {
		this.ingre_seq = ingre_seq;
	}
	public String getFrigo_expiration() {
		return frigo_expiration;
	}
	public void setFrigo_expiration(String frigo_expiration) {
		this.frigo_expiration = frigo_expiration;
	}
	public String getFrigo_storage() {
		return frigo_storage;
	}
	public void setFrigo_storage(String frigo_storage) {
		this.frigo_storage = frigo_storage;
	}
	public String getFrigo_wdate() {
		return frigo_wdate;
	}
	public void setFrigo_wdate(String frigo_wdate) {
		this.frigo_wdate = frigo_wdate;
	}

	
}
