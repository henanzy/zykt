package com.hnzy.hot.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.DataDao;
import com.hnzy.hot.pojo.Data;
import com.hnzy.hot.service.DataService;


@Service
public class DataServiceImpl implements DataService{
	
	@Autowired
	private DataDao dataDao;
	
	@Override
	public List<Map<String, Object>> find(@Param("xqm")String xqm,@Param("ldh")String ldh,@Param("dyh")String dyh,
			@Param("hh")String hh) {
		return dataDao.find(xqm, ldh, dyh, hh);
	}

	@Override
	public Data findf(String fpbh) {
		return dataDao.findf(fpbh);
	}

	@Override
	public void updateS(String ms, String dw, double gdg, double zdS, double gdd, double dgdg, double dzdS, double dgdd,
			String jf, int sdw, int sw, String kg, int bj, String jj, String time) {
		dataDao.updateS(ms, dw, gdg, zdS, gdd, dgdg, dzdS, dgdd, jf, sdw, sw, kg, bj, jj, time);		
	}

	@Override
	public void updateYhbhF(Data data)
	{
		dataDao.updateYhbhF(data);
	}

 
	@Override
	public void InsertYh(Data data)
	{
		dataDao.InsertYh(data);
	}

	@Override
	public List<Map<String, String>> searchInfo(String xqm, String ldh, String dyh, String hh, String time1, String time2)
	{
		return dataDao.searchInfo(xqm, ldh, dyh, hh, time1, time2);
	}

	@Override
	public List<Data> searchHistory(String xqm, String ldh, String dyh, String hh, String time1, String time2)
	{
		return dataDao.searchHistory(xqm, ldh, dyh, hh, time1, time2);
	}

	@Override
	public Data findData(String yhbh, String fpdz)
	{
		return dataDao.findData(yhbh, fpdz);
	}

	@Override
	public Data findYh(String yhbh, Integer fpdz)
	{
		return dataDao.findYh(yhbh, fpdz);
	}

	@Override
	public void updateJf(Data datajf)
	{
		dataDao.updateJf(datajf);
	}

	@Override
	public void InsertYhSSb(Data data)
	{
		dataDao.InsertYhSSb(data);
	}


	@Override
	public void update(String bj,String yhbh,String fpdz)
	{
		dataDao.update(bj,yhbh, fpdz);
	}

	@Override
	public List<Data> SearchHistoryYc( String xqm, String ldh, String dyh, Integer hh,String bj)
	{
		return dataDao.SearchHistoryYc( xqm, ldh, dyh, hh,bj);
	}

	@Override
	public int TxycNum(String time)
	{
		return dataDao.TxycNum(time);
	}

	@Override
	public int DrycNum(String bj)
	{
		return dataDao.DrycNum(bj);
	}

//	@Override
//	public Data findZyydl(String yzbh) {
//		// TODO Auto-generated method stub
//		return dataDao.findZyydl(yzbh);
//	}

	@Override
	public List<Map<String, Object>> SearchYc(String bj) {
		// TODO Auto-generated method stub
		return dataDao.SearchYc(bj);
	}

	@Override
	public Data findZyydl(String yzbh) {
		// TODO Auto-generated method stub
		return dataDao.findZyydl(yzbh);
	}

	@Override
	public void updateSbJs(Data data) {
		// TODO Auto-generated method stub
		dataDao.updateSbJs(data);
	}

	@Override
	public void updatebj(String yhbh, String fpdz, String bj) {
		// TODO Auto-generated method stub
		dataDao.updatebj(yhbh, fpdz,bj);
	}

	@Override
	public List<Map<String, String>> finds() {
		// TODO Auto-generated method stub
		return dataDao.finds();
	}

	@Override
	public Integer findFpNum(String xqm) {
		// TODO Auto-generated method stub
		return dataDao.findFpNum(xqm);
	}

	@Override
	public Integer findYhNum(String xqm) {
		// TODO Auto-generated method stub
		return dataDao.findYhNum(xqm);
	}

	@Override
	public List<Map<String, Object>> findYhSy(String xqm) {
		// TODO Auto-generated method stub
		return dataDao.findYhSy(xqm);
	}

}
