package com.github.cartrader.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Make;
import com.github.cartrader.repository.MakeRepository;
import com.github.cartrader.service.MakeService;

@Service
public final class DefaultMakeService implements MakeService {
	private final MakeRepository makeRepository;
	
	public DefaultMakeService(MakeRepository makeRepository) {
		this.makeRepository = makeRepository;
	}
	
	@Override
	public Collection<Make> findAll() {
		return makeRepository.findAll();
	}

	@Override
	public Make findById(int id) {
		return makeRepository.findById(id).orElse(null);
	}

}
