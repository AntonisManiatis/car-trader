package com.github.cartrader.service;

import java.util.Collection;
import java.util.Optional;

import com.github.cartrader.entity.Make;
import com.github.cartrader.entity.Model;

public interface ModelService {
	Collection<Model> findByMake(Make make);
	
	Optional<Model> findById(int id);
}
