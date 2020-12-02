package com.github.cartrader.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Trader;
import com.github.cartrader.repository.TraderRepository;
import com.github.cartrader.service.TraderService;

@Service
public final class DefaultTraderService implements TraderService {
	private final TraderRepository sellerRepository;
	
	@Autowired
	public DefaultTraderService(TraderRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}
	
	@Override
	public Optional<Trader> findById(long id) {
		return sellerRepository.findById(id);
	}

	@Override
	public void store(Trader seller) {
		sellerRepository.save(seller);
	}
}
