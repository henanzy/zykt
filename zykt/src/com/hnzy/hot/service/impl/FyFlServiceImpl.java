package com.hnzy.hot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.FyFlDao;
import com.hnzy.hot.pojo.FyFl;
import com.hnzy.hot.service.FyFlService;

@Service
public class FyFlServiceImpl implements FyFlService{
	
	@Autowired
	private FyFlDao fyFlDao;
//
//	@Override
//	public List<FyFl> find() {
//		return fyFlDao.find();
//	}
//
//	@Override
//	public void Insert(FyFl fyFl) {
//		fyFlDao.Insert(fyFl);
//	}
//
//	@Override
//	public void delete(String id) {
//		fyFlDao.delete(Integer.parseInt(id));
//	}
//
//	@Override
//	public void update(FyFl fyFl) {
//		fyFlDao.update(fyFl);
//	}

	@Override
	public FyFl byFyFl(int fyfl) {
		return fyFlDao.byFyFl(fyfl);
	}

	
}
