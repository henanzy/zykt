package com.hnzy.hot.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hnzy.hot.pojo.Cg;
import com.hnzy.hot.pojo.YhMessage;


public interface YhMessageService {

	public List<YhMessage> find();
	public List<YhMessage> xfind();
    public void addYh(YhMessage yhMessage);
	
	public void updateYh(YhMessage yhMessage);
	
	public void deleteYh(int id);
	
	public List<YhMessage> findByTerm(@Param("yhbh")String yhbh,@Param("yhxm")String yhxm,@Param("xqm")String xqm);
	
	public List<Map<String, String>> findXqm();
	public List<String> findLd(@Param("xqm") String xqm);
	public Map<String, String> findjzqnet(@Param("xqh") String xqh);
	public List<String> findDy(@Param("xqm") String xqm,@Param("ldh") String ldh);
	public YhMessage findCg(@Param("yhbh")String yhbh,@Param("fpdz")String fpdz);
	
	public YhMessage findJzq(@Param("yhbh")String yhbh);
	//更新当前月份
		public void updateYf(@Param("yf")int yf,@Param("yzbh")String yzbh);
		//查找按流量收费的用户月份
		public List<YhMessage> findType();
		//查找层管编号
		public YhMessage findch(@Param("yhbh")String yhbh,@Param("fpdz")String fpdz);
//		public List<Map<String, String>> finds();
		public void updateZq(YhMessage yhMessage);
		public List<Map<String,Object>>findCgzq();
}
