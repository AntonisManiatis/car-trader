package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.Make;

public final class MakeSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 5602350806861175046L;
	
	private final Make make;
	
	public MakeSpecification(Make make) {
		this.make = make;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get("make"), make);
	}
}
