package com.hnzy.hot.pojo;

import java.io.Serializable;

/**
 * 费用分类
 * 
 * @author ms
 *
 */
public class FyFl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String fyfl;
	private Double dj;
	private String ssms;
	private String fl;
	private Double yh;
	private String xqm;
	
	public Double getYh() {
		return yh;
	}

	public String getXqm() {
		return xqm;
	}

	public void setXqm(String xqm) {
		this.xqm = xqm;
	}

	public void setYh(Double yh) {
		this.yh = yh;
	}

	public String getFl() {
		return fl;
	}

	public void setFl(String fl) {
		this.fl = fl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFyfl() {
		return fyfl;
	}

	public void setFyfl(String fyfl) {
		this.fyfl = fyfl;
	}

	public Double getDj() {
		return dj;
	}

	public void setDj(Double dj) {
		this.dj = dj;
	}

	public String getSsms() {
		return ssms;
	}

	public void setSsms(String ssms) {
		this.ssms = ssms;
	}
}
