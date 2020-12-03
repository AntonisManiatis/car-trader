package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.cartrader.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
