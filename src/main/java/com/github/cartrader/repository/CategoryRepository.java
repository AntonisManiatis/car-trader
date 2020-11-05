package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cartrader.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
