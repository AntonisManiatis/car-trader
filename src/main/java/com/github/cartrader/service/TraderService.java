package com.github.cartrader.service;

import java.util.Optional;

import com.github.cartrader.entity.Trader;

public interface TraderService {
	Optional<Trader> findById(long id);
	
	void store(Trader seller);
}
