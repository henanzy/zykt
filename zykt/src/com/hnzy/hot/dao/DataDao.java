package com.hnzy.hot.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hnzy.hot.pojo.Data;
import com.hnzy.hot.pojo.YhMessage;



public interface DataDao{

public List<Map<String, Object>> find(@Param("xqm")String xqm,@Param("ldh")String ldh,@Param("dyh")String dyh,
		@Param("hh")String hh);
	
	public Data findf(String fpbh);
	
	//根据用户编号更新
	public void updateS(String ms, String dw, double gdg, double zdS, double gdd, double dgdg, double dzdS, double dgdd,
			String jf, int sdw, int sw, String kg, int bj, String jj, String time);
	public Data findData(@Param("yhbh")String yhbh,@Param("fpdz")String fpdz);
	//根据用户编号和风盘地址更新实时数据
	public void updateYhbhF(Data data);
	//插入历史数据
	public void InsertYh(Data data);
	//插入实时表
	public void InsertYhSSb(Data data);
	//历史数据
	public List<Data> searchHistory(@Param("xqm")String xqm,@Param("ldh")String ldh,@Param("dyh")String dyh,
				@Param("hh")String hh,@Param("time1") String time1,@Param("time2") String time2);
		//获取计算用户当量，金额
		public Data findYh(@Param("yhbh")String yhbh,@Param("fpdz")Integer fpdz);
		//更新用户费用信息
		public void updateJf(Data data);
	//异常查询 搜索
	public List<Map<String, Object>> SearchYc(@Param("bj") String bj );
	//异常查询历史搜索
	public List<Data> SearchHistoryYc(@Param("xqm")String xqm,@Param("ldh")String ldh,@Param("dyh")String dyh,@Param("hh")Integer hh,@Param("bj") String bj);
	//更新通讯异常报警
	public  void update(@Param("bj")String bj,@Param("yhbh")String yhbh,@Param("fpdz")String fpdz );
	//通讯异常的数目
	public int TxycNum(String time);
	//盗热异常的数目,开盖异常的数目
	public int DrycNum(String bj);
	//根据业主编号查找用户的总已用当量
	public Data findZyydl(String yzbh);
	public List<Map<String, String>> searchInfo(@Param("xqm")String xqm,@Param("ldh")String ldh,@Param("dyh")String dyh,
			@Param("hh")String hh,@Param("time1") String time1,@Param("time2") String time2);
	
	public void updateSbJs(Data data);
	public void updatebj(@Param("yhbh")String yhbh,@Param("fpdz")String fpdz,@Param("bj")String bj);
	public List<Map<String, String>> finds();
	//查询有多少个风盘在运行
	public Integer findFpNum(@Param("xqm")String xqm);
	//查询有多少用户使用
	public Integer findYhNum(@Param("xqm")String xqm);
	public List<Map<String,Object>>findYhSy(@Param("xqm")String xqm);
}
