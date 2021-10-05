package com.monka.potal.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monka.potal.api.model.Developer;
import com.monka.potal.api.repository.DeveloperRepository;

@Service
public class DeveloperService {
	
	private final DeveloperRepository repository;
	
	public DeveloperService(DeveloperRepository developerRepository) {
		this.repository = developerRepository;
	}
	
	public List<Developer> getAllDevelopers(){
		List<Developer> developers = new ArrayList<>(); 
		repository.findAll().forEach(entity -> developers.add(map(entity)));
		return developers;
	}
	
	public Developer getDeveloperById(Long developerId) {
		return map(repository.findById(developerId).orElse(new com.monka.potal.api.entity.Developer()));
	}
	
	public Developer save(Developer developer) {
		return map(repository.save(map(developer)));
	}
	
	public Developer update(Long developerId, Developer developer) {
		//developer.setId();
		return map(repository.save(map(developer)));
	}
	
	public Developer delete(Long developerId) {
		Optional<com.monka.potal.api.entity.Developer> opt = repository.findById(developerId);
		if(opt.isPresent()) {
			repository.deleteById(developerId);
			return map(opt.get());
		} else {
			return new Developer();
		}
	}
	
	private Developer map(com.monka.potal.api.entity.Developer source) {
		Developer target = new Developer();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		return target;
	}
	
	private com.monka.potal.api.entity.Developer map(Developer source) {
		com.monka.potal.api.entity.Developer target = new com.monka.potal.api.entity.Developer();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setEmail(source.getEmail());
		return target;
	}
}
