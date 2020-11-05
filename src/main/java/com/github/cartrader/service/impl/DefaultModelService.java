package com.github.cartrader.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Make;
import com.github.cartrader.entity.Model;
import com.github.cartrader.service.ModelService;

@Service
public final class DefaultModelService implements ModelService {
	@Override
	public Collection<Model> findByMake(Make make) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Model> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
