package com.github.cartrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.github.cartrader.entity.Category;
import com.github.cartrader.service.CategoryService;

@Component
public final class StringToCategoryConverter implements Converter<String, Category>{
	private final CategoryService categoryService;
	
	@Autowired
	public StringToCategoryConverter(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	public Category convert(String source) {
		try {
			var categoryId = Integer.parseInt(source);
			return categoryService.findById(categoryId).orElse(null);
		} catch (NumberFormatException e) {
			return null;
		}
	}
}
