package com.hnzy.hot.service;

import java.util.List;

import com.hnzy.hot.pojo.Gl;
import com.hnzy.hot.pojo.Rz;


public interface RzService {

    public void Insert(Rz rz);
	
	public List<Rz> find();
	public List<Rz>Search(String cz);
}
