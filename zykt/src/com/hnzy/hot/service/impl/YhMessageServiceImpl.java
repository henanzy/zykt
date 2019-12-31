package com.hnzy.hot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hnzy.hot.dao.YhMessageDao;
import com.hnzy.hot.pojo.YhMessage;
import com.hnzy.hot.service.YhMessageService;


@Service
public class YhMessageServiceImpl implements YhMessageService{
	
	@Autowired
	private YhMessageDao yhMessageDao;
	
//	@Override
//	public List<YhMessage> find() {
//		return yhMessageDao.finds();
//	}

	@Override
	public void addYh(YhMessage yhMessage) {
		// TODO Auto-generated method stub
		yhMessageDao.addYh(yhMessage);
	}

	@Override
	public void updateYh(YhMessage yhMessage) {
		// TODO Auto-generated method stub
		yhMessageDao.updateYh(yhMessage);
	}

	@Override
	public void deleteYh(int id) {
		// TODO Auto-generated method stub
		yhMessageDao.deleteYh(id);
	}

	@Override
	public List<YhMessage> findByTerm(String yhbh,String yhxm,String xqm) {
		// TODO Auto-generated method stub
		return yhMessageDao.findByTerm(yhbh,yhxm,xqm);
	}

	@Override
	public List<Map<String, String>> findXqm() {
		// TODO Auto-generated method stub
		return yhMessageDao.findXqm();
	}

	@Override
	public YhMessage findCg(String yhbh, String fpdz) {
		// TODO Auto-generated method stub
		return yhMessageDao.findCg(yhbh, fpdz);
	}

	@Override
	public YhMessage findJzq(String yhbh) {
		// TODO Auto-generated method stub
		return yhMessageDao.findJzq(yhbh);
	}

	@Override
	public void updateYf(int yf, String yzbh) {
		yhMessageDao.updateYf(yf, yzbh);
		
	}

	@Override
	public List<YhMessage> findType() {
		// TODO Auto-generated method stub
		return yhMessageDao.findType();
	}

	@Override
	public List<String> findLd(String xqm) {
		// TODO Auto-generated method stub
		return yhMessageDao.findLd(xqm);
	}

	@Override
	public List<String> findDy(String xqm, String ldh) {
		// TODO Auto-generated method stub
		return yhMessageDao.findDy(xqm, ldh);
	}

	@Override
	public YhMessage findch(String yhbh, String fpdz) {
		// TODO Auto-generated method stub
		return yhMessageDao.findch(yhbh, fpdz);
	}

	@Override
	public Map<String, String> findjzqnet(String xqh) {
		// TODO Auto-generated method stub
		return yhMessageDao.findjzqnet(xqh);
	}

//	@Override
//	public List<Map<String, String>> finds() {
//		// TODO Auto-generated method stub
//		return yhMessageDao.finds();
//	}

	@Override
	public List<YhMessage> find() {
		// TODO Auto-generated method stub
		return yhMessageDao.find();
	}

	@Override
	public List<YhMessage> xfind() {
		// TODO Auto-generated method stub
		return yhMessageDao.xfind();
	}

	@Override
	public void updateZq(YhMessage yhMessage) {
		// TODO Auto-generated method stub
		yhMessageDao.updateZq(yhMessage);
	}

	@Override
	public List<Map<String, Object>> findCgzq() {
		// TODO Auto-generated method stub
		return yhMessageDao.findCgzq();
	}
}
