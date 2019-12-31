package com.hnzy.hot.dao;

import java.util.List;

import com.hnzy.hot.pojo.Rz;

public interface RzDao{

	public void Insert(Rz rz);
	
	public List<Rz> find();
	public List<Rz>Search(String cz);
}
