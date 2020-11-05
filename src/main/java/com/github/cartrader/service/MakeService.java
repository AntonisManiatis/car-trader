package com.github.cartrader.service;

import java.util.Collection;

import com.github.cartrader.entity.Make;

public interface MakeService {
	
	Collection<Make> findAll();
	
	Make findById(long id);
}
