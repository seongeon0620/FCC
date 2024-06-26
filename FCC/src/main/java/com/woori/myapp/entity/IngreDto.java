package com.woori.myapp.entity;

public class IngreDto {
	private String ingre_seq = "";
	private String ingre_name = "";
	private String ingre_detail = "";
	private int ingre_energy = 0;
	private float ingre_pro = 0;
	private float ingre_car = 0;
	private float ingre_fat = 0;
	private float ingre_sugars = 0;
	private int ingre_na = 0;
	
	public IngreDto () {}
	
	public IngreDto(String ingre_seq, String ingre_name, String ingre_detail, int ingre_energy, float ingre_pro,
			float ingre_car, float ingre_fat, float ingre_sugars, int ingre_na) {
		super();
		this.ingre_seq = ingre_seq;
		this.ingre_name = ingre_name;
		this.ingre_detail = ingre_detail;
		this.ingre_energy = ingre_energy;
		this.ingre_pro = ingre_pro;
		this.ingre_car = ingre_car;
		this.ingre_fat = ingre_fat;
		this.ingre_sugars = ingre_sugars;
		this.ingre_na = ingre_na;
	}
	public String getIngre_seq() {
		return ingre_seq;
	}
	public void setIngre_seq(String ingre_seq) {
		this.ingre_seq = ingre_seq;
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
	
}
