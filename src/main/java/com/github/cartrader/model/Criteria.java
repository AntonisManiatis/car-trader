package com.github.cartrader.model;

import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import com.github.cartrader.entity.Ad;
import com.github.cartrader.entity.AdPurpose;
import com.github.cartrader.entity.CarCondition;
import com.github.cartrader.entity.Category;
import com.github.cartrader.entity.DrivetrainType;
import com.github.cartrader.entity.Feature;
import com.github.cartrader.entity.FuelType;
import com.github.cartrader.entity.Make;
import com.github.cartrader.entity.Model;
import com.github.cartrader.entity.SellerType;
import com.github.cartrader.entity.spec.*;

/**
 * https://medium.com/javarevisited/an-effective-way-to-use-java-enums-in-your-spring-application-485c969794a8
 * @author Anthony
 */
public class Criteria {
	private Set<CarCondition> conditions = Set.of();
	private Set<AdPurpose> purposes = Set.of();
	private Set<Category> categories = Set.of();

	private Set<Make> makes = Set.of();
	private Set<Model> models = Set.of();
	
	private Long priceMin;
	private Long priceMax;
	
	private Integer yearFrom;
	private Integer yearTo;
	
	private Integer mileage;
	
	private Integer engineSizeMin;
	private Integer engineSizeMax;
	
	private Set<FuelType> fuelTypes = Set.of();
	
	private Set<DrivetrainType> drivetrains = Set.of();
	private Set<SellerType> sellerTypes = Set.of();
	private Set<Feature> features = Set.of();
	
	private Specification<Ad> specification = Specification.where(null);
	
	public Set<CarCondition> getConditions() {
		return conditions;
	}
	
	public void setCondition(Set<CarCondition> conditions) {
		var conditionSpecification = Specification.<Ad>where(null);
		for (var condition : conditions) {
			conditionSpecification = conditionSpecification.or(new ConditionSpecification(condition));
		}
		
		this.specification = specification.and(conditionSpecification);
		this.conditions = conditions;
	}
	
	public Set<AdPurpose> getPurposes() {
		return purposes;
	}

	public void setPurpose(Set<AdPurpose> purposes) {
		var purposeSpecification = Specification.<Ad>where(null);
		for (var purpose : purposes) {
			purposeSpecification = purposeSpecification.or(new AdPurposeSpecification(purpose));
		}
		
		this.specification = specification.and(purposeSpecification);
		this.purposes = purposes;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategory(Set<Category> categories) {
		var categorySpecification = Specification.<Ad>where(null);
		for (var category : categories) {
			categorySpecification = categorySpecification.or(new CategorySpecification(category));
		}
		
		this.specification = specification.and(categorySpecification);
		this.categories = categories;
	}

	public Set<Make> getMakes() {
		return makes;
	}
	
	public void setMake(Set<Make> makes) {
		var makeSpecification = Specification.<Ad>where(null);
		for (var make : makes) {
			makeSpecification = makeSpecification.or(new MakeSpecification(make));
		}
		
		this.specification = specification.and(makeSpecification);
		this.makes = makes;
	}
	
	public Set<Model> getModels() {
		return models;
	}

	public void setModels(Set<Model> models) {
		var modelSpecification = Specification.<Ad>where(null);
		for (var model : models) {
			modelSpecification = modelSpecification.or(new ModelSpecification(model));
		}
		
		this.models = models;
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
		var fuelSpecification = Specification.<Ad>where(null);
		for (var fuelType : fuelTypes) {
			fuelSpecification = fuelSpecification.or(new FuelTypeSpecification(fuelType));
		}
		
		this.specification = this.specification.and(fuelSpecification);
		this.fuelTypes = fuelTypes;
	}

	public Set<DrivetrainType> getDrivetrains() {
		return drivetrains;
	}

	public void setDrivetrain(Set<DrivetrainType> drivetrains) {
		drivetrains.forEach((drivetrain) -> {
			this.specification = specification.and(new DrivetrainTypeSpecification(drivetrain));
		});
		
		this.drivetrains = drivetrains;
	}

	public Set<SellerType> getSellerTypes() {
		return sellerTypes;
	}

	public void setSellerType(Set<SellerType> sellerTypes) {
		var sellerTypeSpecification = Specification.<Ad>where(null);
		for (var sellerType : sellerTypes) {
			sellerTypeSpecification = sellerTypeSpecification.or(new SellerTypeSpecification(sellerType));
		}
		
		this.specification = this.specification.and(sellerTypeSpecification);
		this.sellerTypes = sellerTypes;
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
