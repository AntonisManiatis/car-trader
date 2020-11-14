package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.Model;

public final class ModelSpecification implements Specification<Ad> {
	private static final long serialVersionUID = 6269390560880957476L;
	
	private final Model model;
	
	public ModelSpecification(Model model) {
		this.model = model;
	}

	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get("car").get("model"), model);
	}
}
