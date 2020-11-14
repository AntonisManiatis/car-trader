package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cartrader.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Integer> {

}
