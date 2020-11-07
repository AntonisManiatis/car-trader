package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;

public final class ToYearSpecification implements Specification<Ad> {
	private static final long serialVersionUID = -8032799277780486786L;
	
	private final int year;
	
	public ToYearSpecification(int year) {
		this.year = year;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.lessThanOrEqualTo(root.get("car").get("modelYear"), year);
	}
}
