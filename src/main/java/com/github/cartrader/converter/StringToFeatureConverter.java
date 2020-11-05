package com.github.cartrader.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.cartrader.entity.Feature;
import com.github.cartrader.service.FeatureService;

@Component
public final class StringToFeatureConverter implements Converter<String, Feature> {
	private final FeatureService featureService;
	
	public StringToFeatureConverter(FeatureService featureService) {
		this.featureService = featureService;
	}
	
	@Override
	public Feature convert(String source) {
		var id = Integer.parseInt(source);
		return featureService.findById(id).orElse(null);
	}
}
