package com.hnzy.hot.pojo;

import java.io.Serializable;
/**
 * 收费模式
 * @author ms
 *
 */
public class SfMs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String ms;//模式

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMs() {
		return ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
