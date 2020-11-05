package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;

public final class MinPriceSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 1263370642667565632L;
	
	private final long price;
	
	public MinPriceSpecification(long price) {
		this.price = price;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.greaterThan(root.get("price"), price);
	}
}
