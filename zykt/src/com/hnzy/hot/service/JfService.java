package com.hnzy.hot.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hnzy.hot.pojo.Jf;


public interface JfService {


	public List<Map<String, String>> find(@Param("xqm") String xqm,@Param("ldh") String ldh,@Param("dyh") String dyh,@Param("hh") String hh,@Param("type") Integer type);

	public void updateJfHjje(@Param("yzbh")String yzbh,@Param("jfje")String jfje,@Param("syje")String syje,@Param("hjje")String hjje,@Param("time") Date time,@Param("userName")String userName,@Param("type")Integer type,@Param("startTime")String startTime,@Param("endTime")String endTime);

	public void InsertJfHistory(@Param("yzbh")String yzbh,@Param("jfje")String jfje,@Param("syje")String syje, @Param("hjje")String hjje,@Param("time")Date time,@Param("userName")String userName,@Param("type")Integer type,@Param("startTime")String startTime,@Param("endTime")String endTime,@Param("outtradeno")String outtradeno);

	
	//根据 缴费时间查询缴费笔数(当日)
		public int findJfbs( );
		
		//根据 缴费时间查询缴费总金额(当日)
		public Integer findJfzje( );
		
		//根据 缴费时间查询缴费笔数(本周)
		public int findBzJfbs( );
		
		//根据 缴费时间查询缴费总金额(本周)
		public Integer findBzJfzje( );
		
		public List<Map<String, String>> findHistory();
		
		public List<Map<String, String>> findDj();
		//根据用户编号更新缴费syje
		public void updateJf(Jf jf);
		public Double selSyje(String yzbh);
}
