package com.github.cartrader.service;

import java.util.Collection;
import java.util.Optional;

import com.github.cartrader.entity.Category;

public interface CategoryService {
	Collection<Category> findAll();
	
	Optional<Category> findById(int id);
}
