package com.github.cartrader.entity.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.Category;

/**
 * 
 * @author Anthony
 */
public final class CategorySpecification implements Specification<Ad> {
	private static final long serialVersionUID = 1L;
	
	private final Category category;
	
	public CategorySpecification(Category category) {
		this.category = category;
	}
	
	@Override
	public Predicate toPredicate(Root<Ad> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return cb.equal(root.get("category"), category);
	}
}
