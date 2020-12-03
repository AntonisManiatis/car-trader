package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.cartrader.entity.Make;

@Repository
public interface MakeRepository extends JpaRepository<Make, Integer> {

}
