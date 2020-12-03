package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.cartrader.entity.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {

}
