package com.hnzy.hot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.FpDao;
import com.hnzy.hot.pojo.Fp;
import com.hnzy.hot.service.FpService;
@Service
public class FpServiceImpl implements FpService{

	@Autowired
	public FpDao fpDao;
	
	@Override
	public List<Fp> findFp() {
		// TODO Auto-generated method stub
		return fpDao.findFp();
	}

	@Override
	public void updateFp(Fp fp) {
		// TODO Auto-generated method stub
		fpDao.updateFp(fp);
	}

	@Override
	public void deleteFp(int id) {
		// TODO Auto-generated method stub
		fpDao.deleteFp(id);
	}

	@Override
	public void addFp(Fp fp) {
		// TODO Auto-generated method stub
		fpDao.addFp(fp);
	}

}
