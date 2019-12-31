package com.hnzy.hot.pojo;

import java.io.Serializable;

/**
 * 层管表3
 * 
 * @author Administrator
 *
 */
public class Cg implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String cgbh; // 层管编号
	private String jzqnet; // 集中器net
	private String azdz; // 安装地址
	private String bz; // 备注
	private String jzqip;
	private String jzqport;
	private String ldh  ;  //楼栋
	private String dyh  ;  //单元
	private String xqh;//小区号
	
	public String getXqh() {
		return xqh;
	}

	public void setXqh(String xqh) {
		this.xqh = xqh;
	}

	public String getJzqip() {
		return jzqip;
	}

	public void setJzqip(String jzqip) {
		this.jzqip = jzqip;
	}

	public String getLdh() {
		return ldh;
	}

	public void setLdh(String ldh) {
		this.ldh = ldh;
	}

	public String getDyh() {
		return dyh;
	}

	public void setDyh(String dyh) {
		this.dyh = dyh;
	}

	public String getJzqport() {
		return jzqport;
	}

	public void setJzqport(String jzqport) {
		this.jzqport = jzqport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCgbh() {
		return cgbh;
	}

	public void setCgbh(String cgbh) {
		this.cgbh = cgbh;
	}

	public String getJzqnet() {
		return jzqnet;
	}

	public void setJzqnet(String jzqnet) {
		this.jzqnet = jzqnet;
	}

	public String getAzdz() {
		return azdz;
	}

	public void setAzdz(String azdz) {
		this.azdz = azdz;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	
	

	

	 

	 

}
