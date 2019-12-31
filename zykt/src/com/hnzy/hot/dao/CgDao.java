package com.hnzy.hot.dao;

import java.util.List;
import java.util.Map;

import com.hnzy.hot.pojo.Cg;



public interface CgDao{

public List<Cg> find();

public void Insert(Cg cg);

public void deletecg(int id);
	
public void update(Cg cg);
	
public Cg findLdDyByCg(String cgbh);
}
