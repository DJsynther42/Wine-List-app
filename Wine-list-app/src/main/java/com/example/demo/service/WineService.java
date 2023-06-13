package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Wine;

public interface WineService {
	List<Wine> getAllWine();
	void saveWine(Wine wine);
	Wine getWineById(long id);
	void deleteWineById(long id);
}