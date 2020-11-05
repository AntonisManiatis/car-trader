package com.github.cartrader.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Category;
import com.github.cartrader.repository.CategoryRepository;
import com.github.cartrader.service.CategoryService;

@Service
public final class DefaultCategoryService implements CategoryService {
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public DefaultCategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public Collection<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findById(int id) {
		return categoryRepository.findById(id);
	}
}
