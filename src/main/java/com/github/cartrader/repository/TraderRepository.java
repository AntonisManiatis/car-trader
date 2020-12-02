package com.github.cartrader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.cartrader.entity.Trader;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Long> {

}
