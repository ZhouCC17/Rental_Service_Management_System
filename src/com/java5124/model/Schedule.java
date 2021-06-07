package com.java5124.model;

public class Schedule {
	private int sid;
	private int wid;
	private String scontent;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	@Override
	public String toString() {
		return "Schedule [scontent=" + scontent + "]";
	}
	
	
}
