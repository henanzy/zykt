package com.hnzy.hot.service;

import java.util.List;

import com.hnzy.hot.pojo.Cg;


public interface CgService {


public List<Cg> find();

public void Insert(Cg cg);

public void deletecg(int id);
	
public void update(Cg cg);
public Cg findLdDyByCg(String cgbh);
}
