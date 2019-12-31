package com.hnzy.hot.service;

import java.util.List;

import com.hnzy.hot.pojo.Dj;

public interface DjService {
	public List<Dj> findDj();
	public void addDj(Dj dj);
	public void updateDj(Dj dj);
	public void delete(int id);
}
