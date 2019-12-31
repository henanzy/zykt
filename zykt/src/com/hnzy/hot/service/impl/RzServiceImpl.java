package com.hnzy.hot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnzy.hot.dao.RzDao;
import com.hnzy.hot.pojo.Rz;
import com.hnzy.hot.service.RzService;


@Service
public class RzServiceImpl implements RzService{
	
	@Autowired
	private RzDao rzDao;

	@Override
	public void Insert(Rz rz) {
		// TODO Auto-generated method stub
		rzDao.Insert(rz);
	}

	@Override
	public List<Rz> find() {
		// TODO Auto-generated method stub
		return rzDao.find();
	}

	@Override
	public List<Rz> Search(String cz) {
		// TODO Auto-generated method stub
		return rzDao.Search(cz);
	}
}
