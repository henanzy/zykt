package com.hnzy.hot.pojo;

import java.io.Serializable;
import java.util.Date;

public class Rz implements Serializable {
	private int id;
	private String czr;
	private String cz;
	private Date czsj;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public String getCz() {
		return cz;
	}
	public void setCz(String cz) {
		this.cz = cz;
	}
	public Date getCzsj() {
		
		return czsj;
	}
	public void setCzsj(Date czsj) {
		this.czsj = czsj;
	}
	@Override
	public String toString() {
		return "Rz [id=" + id + ", czr=" + czr + ", cz=" + cz + ", czsj=" + czsj + "]";
	}
	
	
}
