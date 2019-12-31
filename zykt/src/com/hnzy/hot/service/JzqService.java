package com.hnzy.hot.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hnzy.hot.pojo.Jzq;

public interface JzqService {
	public List<Jzq> find();
	public void addJzq(Jzq jzq);
	public void updateJzq(Jzq jzq);
	public int deleteJzq(String jzqnet);
	//更新ip port
	public void updateIpPort(@Param("jzqip") String jzqip,@Param("jzqport") Integer jzqport, @Param("jzqnet") String jzqnet, @Param("updateTime") String updateTime);
}
