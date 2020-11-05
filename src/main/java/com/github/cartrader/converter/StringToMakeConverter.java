package com.github.cartrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.github.cartrader.entity.Make;
import com.github.cartrader.service.MakeService;

@Component
public final class StringToMakeConverter implements Converter<String, Make> {
	private final MakeService makeService;
	
	@Autowired
	public StringToMakeConverter(MakeService makeService) {
		Assert.notNull(makeService, () -> "Make Service cannot be null!");
		this.makeService = makeService;
	}
	
	@Override
	public Make convert(String source) {
		var id = Integer.parseInt(source);
		return makeService.findById(id);
	}
}
