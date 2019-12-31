package com.hnzy.hot.service;

import java.util.List;

import com.hnzy.hot.pojo.Gl;


public interface GlService {

    public List<Gl> find();
	
	public void Insert(Gl gl);
	
	public void update(Gl gl);
	
	public void delete(int id);
	public Gl findGlbyXh(String xh);
}
