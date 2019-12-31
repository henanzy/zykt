package com.hnzy.hot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.CgDao;
import com.hnzy.hot.pojo.Cg;
import com.hnzy.hot.service.CgService;


@Service
public class CgServiceImpl implements CgService{
	
	@Autowired
	private CgDao cgDao;

	@Override
	public List<Cg> find() {
		// TODO Auto-generated method stub
		return cgDao.find();
	}

	@Override
	public void Insert(Cg cg) {
		// TODO Auto-generated method stub
		cgDao.Insert(cg);
	}

	@Override
	public void deletecg(int id) {
		// TODO Auto-generated method stub
		cgDao.deletecg(id);
	}

	@Override
	public void update(Cg cg) {
		// TODO Auto-generated method stub
		cgDao.update(cg);
	}

	public Cg findLdDyByCg(String cgbh) {
		// TODO Auto-generated method stub
		return cgDao.findLdDyByCg(cgbh);
	}
	
}
