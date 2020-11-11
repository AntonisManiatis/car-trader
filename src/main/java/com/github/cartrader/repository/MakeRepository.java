package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.cartrader.entity.Make;

public interface MakeRepository extends JpaRepository<Make, Integer> {

}
