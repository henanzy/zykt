package com.hnzy.hot.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.JfDao;
import com.hnzy.hot.pojo.Jf;
import com.hnzy.hot.service.JfService;


@Service
public class JfServiceImpl implements JfService{
	
	@Autowired
	private JfDao jfDao;

	

	@Override
	public void updateJfHjje(String yzbh, String jfje, String syje, String hjje, Date time, String userName,
			Integer type, String startTime, String endTime) {
		// TODO Auto-generated method stub
		jfDao.updateJfHjje(yzbh, jfje, syje, hjje, time, userName, type, startTime, endTime);
	}



	@Override
	public List<Map<String, String>> find(String xqm, String ldh, String dyh, String hh, Integer type) {
		// TODO Auto-generated method stub
		return jfDao.find(xqm, ldh, dyh, hh, type);
	}



	@Override
	public void InsertJfHistory(String yzbh, String jfje, String syje, String hjje, Date time, String userName,
			Integer type, String startTime, String endTime, String outtradeno) {
		// TODO Auto-generated method stub
		jfDao.InsertJfHistory(yzbh, jfje, syje, hjje, time, userName, type, startTime, endTime, outtradeno);
	}



	@Override
	public int findJfbs() {
		// TODO Auto-generated method stub
		return jfDao.findJfbs();
	}



	@Override
	public Integer findJfzje() {
		// TODO Auto-generated method stub
		return jfDao.findJfzje();
	}



	@Override
	public int findBzJfbs() {
		// TODO Auto-generated method stub
		return jfDao.findBzJfbs();
	}



	@Override
	public Integer findBzJfzje() {
		// TODO Auto-generated method stub
		return jfDao.findBzJfzje();
	}



	@Override
	public List<Map<String, String>> findHistory() {
		// TODO Auto-generated method stub
		return jfDao.findHistory();
	}



	@Override
	public List<Map<String, String>> findDj() {
		// TODO Auto-generated method stub
		return jfDao.findDj();
	}



	@Override
	public void updateJf(Jf jf) {
		// TODO Auto-generated method stub
		jfDao.updateJf(jf);
	}



	@Override
	public Double selSyje(String yzbh) {
		// TODO Auto-generated method stub
		return jfDao.selSyje(yzbh);
	}
	
}
