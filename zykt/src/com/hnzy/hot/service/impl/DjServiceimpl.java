package com.hnzy.hot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.DjDao;
import com.hnzy.hot.pojo.Dj;
import com.hnzy.hot.service.DjService;

@Service
public class DjServiceimpl implements DjService {

	@Autowired
	private DjDao djDao;
	@Override
	public List<Dj> findDj() {
		// TODO Auto-generated method stub
		return djDao.findDj();
	}

	@Override
	public void addDj(Dj dj) {
		djDao.addDj(dj);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDj(Dj dj) {
		// TODO Auto-generated method stub
		djDao.updateDj(dj);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		djDao.delete(id);
	}

}
