package com.hnzy.hot.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.JzqDao;
import com.hnzy.hot.pojo.Jzq;
import com.hnzy.hot.service.JzqService;
@Service
public class JzqServiceImpl implements JzqService {

	@Autowired
	private JzqDao jzqDao;
	@Override
	public List<Jzq> find() {
		// TODO Auto-generated method stub
		return jzqDao.find();
	}
	@Override
	public void addJzq(Jzq jzq) {
		jzqDao.addJzq(jzq);
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateJzq(Jzq jzq) {
		jzqDao.updateJzq(jzq);
		// TODO Auto-generated method stub
		
	}
	@Override
	public int deleteJzq(String jzqnet) {
		// TODO Auto-generated method stub
		int i=jzqDao.deleteJzq(jzqnet);
		return i;
	}
	@Override
	public void updateIpPort(String jzqip, Integer jzqport, String jzqnet, String updateTime) {
		// TODO Auto-generated method stub
		jzqDao.updateIpPort(jzqip, jzqport, jzqnet,updateTime);
	}

}
