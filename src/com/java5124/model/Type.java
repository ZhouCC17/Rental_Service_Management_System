package com.java5124.model;

public class Type {
	private int tid;
	private String type;
	
	
	
	public int getTid() {
		return tid;
	}



	public void setTid(int tid) {
		this.tid = tid;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString(){
		return this.type;
	}
}
