package com.github.cartrader.seeder;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.cartrader.entity.Feature;
import com.github.cartrader.entity.FeatureType;
import com.github.cartrader.repository.FeatureRepository;

@Component
@Profile("dev")
public final class FeatureSeeder implements CommandLineRunner {
	private final FeatureRepository featureRepository;
	
	@Autowired
	public FeatureSeeder(FeatureRepository featureRepository) {
		this.featureRepository = featureRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		var features = new ArrayList<Feature>();
		var feature = new Feature();
		feature.setName("ABS");
		feature.setType(FeatureType.SAFETY);
		features.add(feature);
		
		feature = new Feature();
		feature.setName("Traction Control");
		feature.setType(FeatureType.SAFETY);
		features.add(feature);
		
		feature = new Feature();
		feature.setName("Seat heaters");
		feature.setType(FeatureType.OTHER);
		features.add(feature);
		
		this.featureRepository.saveAll(features);
	}
}
