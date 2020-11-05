package com.github.cartrader.service;

import java.util.Optional;
import java.util.Set;

import com.github.cartrader.entity.Feature;

public interface FeatureService {
	Set<Feature> findAll();
	
	Optional<Feature> findById(int id);
}
