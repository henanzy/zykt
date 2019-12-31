package com.hnzy.hot.service;

import java.util.List;

import com.hnzy.hot.pojo.Fp;

public interface FpService {

	public List<Fp> findFp();
	public void updateFp(Fp fp);
	public void deleteFp(int id);
	public void addFp(Fp fp);
}
