package com.hnzy.hot.dao;

import java.util.List;

import com.hnzy.hot.pojo.Fp;

public interface FpDao {

	public List<Fp> findFp();
	public void updateFp(Fp fp);
	public void deleteFp(int id);
	public void addFp(Fp fp);
}
