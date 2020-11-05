package com.github.cartrader.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.repository.AdRepository;
import com.github.cartrader.service.AdService;

@Service
public final class DefaultAdService implements AdService {
	private final AdRepository repository;
	
	@Autowired
	public DefaultAdService(AdRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Page<Ad> findAll(Specification<Ad> spec, Pageable pageable) {
		return repository.findAll(spec, pageable);
	}
	
	@Override
	public Optional<Ad> findById(long id) {
		return repository.findById(id);
	}
}
