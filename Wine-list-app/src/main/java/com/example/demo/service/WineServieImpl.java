package com.example.demo.service;	

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Wine;
import com.example.demo.repository.WineRepository;

@Service
public class WineServieImpl implements WineService{

	@Autowired
	private WineRepository wineRepository;
	
	@Override
	public List<Wine> getAllWine() {
		return wineRepository .findAll();
	}
	
	@Override
	public void saveWine(Wine wine) {
		this.wineRepository.save(wine);
	}
	
	@Override
	public Wine getWineById(long id) {
		Optional<Wine> optional = wineRepository.findById(id);
		Wine wine = null;
		if(optional.isPresent()) {
			wine = optional.get();
		}else {
			throw new RuntimeException(" Wine not found for id :: " + id);
		}
		return wine;
	}
	
	@Override
	public void deleteWineById(long id) {
		this.wineRepository.deleteById(id);
	}
	
}
