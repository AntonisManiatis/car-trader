package com.github.cartrader.seeder;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.cartrader.entity.Category;
import com.github.cartrader.repository.CategoryRepository;

@Component
@Profile("dev")
public final class CategorySeeder implements CommandLineRunner {
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategorySeeder(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		var categories = new ArrayList<Category>();
		var category = new Category();
		category.setTitle("Sports car");
		category.setPicturePath("/categories/coupe.png");
		categories.add(category);
		
		category = new Category();
		category.setTitle("Hatch");
		category.setPicturePath("/categories/hatch.png");
		categories.add(category);
		
		category = new Category();
		category.setTitle("Convertible");
		category.setPicturePath("/categories/convert.png");
		categories.add(category);
		
		category = new Category();
		category.setTitle("SUV");
		category.setPicturePath("/categories/SUV.png");
		categories.add(category);
		
		category = new Category();
		category.setTitle("Sedan");
		category.setPicturePath("/categories/sedan.png");
		categories.add(category);

		this.categoryRepository.saveAll(categories);
	}
}
