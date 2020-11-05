package com.github.cartrader.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.cartrader.entity.Feature;
import com.github.cartrader.service.FeatureService;

@RestController
public class FeatureController {
	private final FeatureService featureService;
	
	@Autowired
	public FeatureController(FeatureService featureService) {
		this.featureService = featureService;
	}
	
	@GetMapping("/features")
	public Set<Feature> findAll() {
		return featureService.findAll();
	}
}
