package com.github.cartrader.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Feature;
import com.github.cartrader.repository.FeatureRepository;
import com.github.cartrader.service.FeatureService;

@Service
public final class DefaultFeatureService implements FeatureService {
	private final FeatureRepository featureRepository;
	
	public DefaultFeatureService(FeatureRepository featureRepository) {
		this.featureRepository = featureRepository;
	}
	
	@Override
	public Set<Feature> findAll() {
		return Set.copyOf(featureRepository.findAll());
	}

	@Override
	public Optional<Feature> findById(int id) {
		return featureRepository.findById(id);
	}
}
