package com.woori.myapp.entity;

public class LikesDto {
	
	long like_seq = 0L;
	long rcpfrom_seq = 0L;
	int rcpfrom_type = 0;
	long mem_seq = 0L;
	
	public LikesDto() {
		
	}
	
	public LikesDto(long rcpfrom_seq, int rcpfrom_type, long mem_seq) {
		super();
		this.rcpfrom_seq = rcpfrom_seq;
		this.rcpfrom_type = rcpfrom_type;
		this.mem_seq = mem_seq;
	}
	
	public long getLike_seq() {
		return like_seq;
	}
	public void setLike_seq(long like_seq) {
		this.like_seq = like_seq;
	}
	public long getRcpfrom_seq() {
		return rcpfrom_seq;
	}
	public void setRcpfrom_seq(long rcpfrom_seq) {
		this.rcpfrom_seq = rcpfrom_seq;
	}
	public int getRcpfrom_type() {
		return rcpfrom_type;
	}
	public void setRcpfrom_type(int rcpfrom_type) {
		this.rcpfrom_type = rcpfrom_type;
	}
	public long getMem_seq() {
		return mem_seq;
	}
	public void setMem_seq(long mem_seq) {
		this.mem_seq = mem_seq;
	}
	
	

}
