package com.woori.myapp.entity;

public class MainDto {
	// frigo
	private Long frigo_seq = 0L;
	private Long mem_seq = 0L;
	private String ingre_seq = "";
	private String frigo_expiration = "";
	private String frigo_storage = "";
	private String frigo_wdate = "";
	private String ingre_name = "";
	private String f_status = "";
	private int f_cnt = 0;
	private int e_cnt = 0;
	
	// ingre
	private String ingre_detail = "";
	private int ingre_energy = 0;
	private float ingre_pro = 0;
	private float ingre_car = 0;
	private float ingre_fat = 0;
	private float ingre_sugars = 0;
	private int ingre_na = 0;
	
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
	public int getIngre_energy() {
		return ingre_energy;
	}
	public void setIngre_energy(int ingre_energy) {
		this.ingre_energy = ingre_energy;
	}
	public float getIngre_pro() {
		return ingre_pro;
	}
	public void setIngre_pro(float ingre_pro) {
		this.ingre_pro = ingre_pro;
	}
	public float getIngre_car() {
		return ingre_car;
	}
	public void setIngre_car(float ingre_car) {
		this.ingre_car = ingre_car;
	}
	public float getIngre_fat() {
		return ingre_fat;
	}
	public void setIngre_fat(float ingre_fat) {
		this.ingre_fat = ingre_fat;
	}
	public float getIngre_sugars() {
		return ingre_sugars;
	}
	public void setIngre_sugars(float ingre_sugars) {
		this.ingre_sugars = ingre_sugars;
	}
	public int getIngre_na() {
		return ingre_na;
	}
	public void setIngre_na(int ingre_na) {
		this.ingre_na = ingre_na;
	}
	public String getF_status() {
		return f_status;
	}
	public void setF_status(String f_status) {
		this.f_status = f_status;
	}
	public int getF_cnt() {
		return f_cnt;
	}
	public void setF_cnt(int f_cnt) {
		this.f_cnt = f_cnt;
	}
	public int getE_cnt() {
		return e_cnt;
	}
	public void setE_cnt(int e_cnt) {
		this.e_cnt = e_cnt;
	}
	
	

	
	
	

}
