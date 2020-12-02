package com.github.cartrader.seeder;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.github.cartrader.entity.Make;
import com.github.cartrader.entity.Model;
import com.github.cartrader.repository.MakeRepository;

@Component
@Profile("dev")
public final class MakeSeeder implements CommandLineRunner {
	private final MakeRepository makeRepository;
	
	@Autowired
	public MakeSeeder(MakeRepository makeRepository) {
		this.makeRepository = makeRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		var make = new Make();
		make.setName("Mazda");
		var model = new Model();
		model.setName("RX-7");
		make.setModels(Set.of(model));
		
		this.makeRepository.save(make);
		
		make = new Make();
		make.setName("Audi");
		model = new Model();
		model.setName("Quattro");
		make.setModels(Set.of(model));
		
		this.makeRepository.save(make);
	}
}
