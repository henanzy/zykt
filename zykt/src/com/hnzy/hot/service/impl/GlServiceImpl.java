package com.hnzy.hot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.GlDao;
import com.hnzy.hot.pojo.Gl;
import com.hnzy.hot.service.GlService;
import com.hnzy.hot.service.RzService;


@Service
public class GlServiceImpl implements GlService{
	
	@Autowired
	private GlDao glDao;
	
	

	@Override
	public List<Gl> find() {
		// TODO Auto-generated method stub
		return glDao.find();
	}

	@Override
	public void Insert(Gl gl) {
		// TODO Auto-generated method stub
		glDao.Insert(gl);
	}

	@Override
	public void update(Gl gl) {
		// TODO Auto-generated method stub
		glDao.update(gl);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		glDao.delete(id);
	}

	@Override
	public Gl findGlbyXh(String xh) {
		// TODO Auto-generated method stub
		return glDao.findGlbyXh(xh);
	}
	
	
}
