package com.github.cartrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.cartrader.entity.Model;
import com.github.cartrader.service.ModelService;

@Component
public final class StringToModelConverter implements Converter<String, Model> {
	private final ModelService modelService;
	
	@Autowired
	public StringToModelConverter(ModelService modelService) {
		this.modelService = modelService;
	}
	
	@Override
	public Model convert(String source) {
		var id = Integer.parseInt(source);
		return modelService.findById(id).orElse(null);
	}
}
