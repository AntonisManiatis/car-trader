package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.CarCondition;

public final class ConditionSpecification implements Specification<Ad>{
	private static final long serialVersionUID = 1L;
	
	private final CarCondition condition;
	
	public ConditionSpecification(CarCondition condition) {
		this.condition = condition != null ? condition : CarCondition.UNDEFINED;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get("car").get("carCondition"), this.condition);
	}
}
