package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cartrader.entity.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Integer> {

}
