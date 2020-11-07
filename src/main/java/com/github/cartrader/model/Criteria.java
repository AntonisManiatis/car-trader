package com.github.cartrader.model;

import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.AdPurpose;
import com.github.cartrader.entity.CarCondition;
import com.github.cartrader.entity.Category;
import com.github.cartrader.entity.Feature;
import com.github.cartrader.entity.FuelType;
import com.github.cartrader.entity.Make;
import com.github.cartrader.entity.Model;
import com.github.cartrader.entity.spec.*;

/**
 * https://medium.com/javarevisited/an-effective-way-to-use-java-enums-in-your-spring-application-485c969794a8
 * @author Anthony
 */
public class Criteria {
	private Set<CarCondition> conditions = Set.of();
	private Set<AdPurpose> purposes = Set.of();
	private Set<Category> categories = Set.of();
	
	private Long priceMin;
	private Long priceMax;
	
	private Integer yearFrom;
	private Integer yearTo;
	
	private Integer mileage;
	
	private Integer engineSizeMin;
	private Integer engineSizeMax;
	
	private Set<FuelType> fuelTypes = Set.of();
	
	private Set<Feature> features = Set.of();
	private Set<Make> makes = Set.of();
	private Set<Model> models = Set.of();
	
	private Specification<Ad> specification = Specification.where(null);
	
	public Set<CarCondition> getConditions() {
		return conditions;
	}
	
	public void setCondition(Set<CarCondition> conditions) {
		conditions.forEach((condition) -> {
			this.specification = specification.and(new ConditionSpecification(condition));
		});
		
		this.conditions = conditions;
	}
	
	public Set<AdPurpose> getPurposes() {
		return purposes;
	}

	public void setPurpose(Set<AdPurpose> purposes) {
		purposes.forEach((purpose) -> {
			this.specification = specification.and(new AdPurposeSpecification(purpose));
		});
		
		this.purposes = purposes;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategory(Set<Category> categories) {
		categories.forEach((category) -> {
			this.specification = specification.and(new CategorySpecification(category));
		});
		
		this.categories = categories;
	}
	
	public Long getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(long priceMin) {
		this.specification = specification.and(new MinPriceSpecification(priceMin));
		this.priceMin = priceMin;
	}

	public Long getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(long priceMax) {
		this.specification = specification.and(new MaxPriceSpecification(priceMax));
		this.priceMax = priceMax;
	}

	public Integer getYearFrom() {
		return yearFrom;
	}

	public void setYearFrom(int yearFrom) {
		this.specification = specification.and(new FromYearSpecification(yearFrom));
		this.yearFrom = yearFrom;
	}

	public Integer getYearTo() {
		return yearTo;
	}

	public void setYearTo(int yearTo) {
		this.specification = specification.and(new ToYearSpecification(yearTo));
		this.yearTo = yearTo;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.specification = specification.and(new MileageSpecification(mileage));
		this.mileage = mileage;
	}

	public Integer getEngineSizeMin() {
		return engineSizeMin;
	}

	public void setEngineSizeMin(int engineSizeMin) {
		this.specification = specification.and(new MinEngineSizeSpecification(engineSizeMin));
		this.engineSizeMin = engineSizeMin;
	}

	public Integer getEngineSizeMax() {
		return engineSizeMax;
	}

	public void setEngineSizeMax(int engineSizeMax) {
		this.specification = specification.and(new MaxEngineSizeSpecification(engineSizeMax));
		this.engineSizeMax = engineSizeMax;
	}

	public Set<FuelType> getFuelTypes() {
		return fuelTypes;
	}

	public void setFuelType(Set<FuelType> fuelTypes) {
		fuelTypes.forEach((fuelType) -> {
			this.specification = specification.and(new FuelTypeSpecification(fuelType));
		});
		
		this.fuelTypes = fuelTypes;
	}

	public Set<Make> getMakes() {
		return makes;
	}
	
	public void setMake(Set<Make> makes) {
		makes.forEach((make) -> {
			this.specification = specification.and(new MakeSpecification(make));
		});
		
		this.makes = makes;
	}

	public Set<Feature> getFeatures() {
		return features;
	}
	
	public void setFeature(Set<Feature> features) {
		features.forEach((feature) -> {
			this.specification = specification.and(new FeatureSpecification(feature));
		});
		
		this.features = features;
	}
	
	public Specification<Ad> spec() {
		return specification;
	}
	
	@Override
	public String toString() {
		return "Criteria [conditions=" + conditions + "]";
	}
}
