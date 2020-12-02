package com.github.cartrader.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import com.github.cartrader.entity.Ad;

public interface AdService {
	
	Page<Ad> findAll(@Nullable Specification<Ad> spec, Pageable pageable);
	
	Optional<Ad> findById(long id);
	
	Ad save(Ad ad);
}
