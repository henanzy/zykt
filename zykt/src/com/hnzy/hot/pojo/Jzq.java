package com.hnzy.hot.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 集中器表5
 * 
 * @author Administrator
 *
 */
public class Jzq implements Serializable {

	private static final long serialVersionUID = -4072646355182930123L;
	private int id;
	private String jzqnet; // 集中器net
	private String jzqip; //集中ip
	private String jzqport;//集中器端口号
	private String azdz; // 安装地址
	private String updateTime;
//	private YhMessage yhMessage;
//
//	public YhMessage getYhMessage() {
//		return yhMessage;
//	}
//	public void setYhMessage(YhMessage yhMessage) {
//		this.yhMessage = yhMessage;
//	}

	public int getId() {
		return id;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getJzqnet() {
		return jzqnet;
	}

	public void setJzqnet(String jzqnet) {
		this.jzqnet = jzqnet;
	}

	public String getJzqip() {
		return jzqip;
	}

	public void setJzqip(String jzqip) {
		this.jzqip = jzqip;
	}

	public String getJzqport() {
		return jzqport;
	}

	public void setJzqport(String jzqport) {
		this.jzqport = jzqport;
	}

	public String getAzdz() {
		return azdz;
	}

	public void setAzdz(String azdz) {
		this.azdz = azdz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Jzq [id=" + id + ", jzqnet=" + jzqnet + ", jzqip=" + jzqip + ", jzqport=" + jzqport + ", azdz=" + azdz
				+ "]";
	}
}
