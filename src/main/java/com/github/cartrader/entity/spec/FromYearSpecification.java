package com.github.cartrader.entity.spec;

import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;

public final class FromYearSpecification implements Specification<Ad> {
	private static final long serialVersionUID = -2150946092890283062L;
	
	private final int year;
	
	public FromYearSpecification(int year) {
		this.year = year;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.greaterThanOrEqualTo(root.get("car").get("modelYear"), LocalDate.of(year, 1, 1));
	}
}
