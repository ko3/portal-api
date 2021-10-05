package com.monka.potal.api.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monka.potal.api.model.Developer;
import com.monka.potal.api.service.DeveloperService;

@RestController
public class DevelopersController {
	
	private final DeveloperService service;
	
	public DevelopersController(DeveloperService service) {
		this.service = service;
	}

	@GetMapping("/developers")
	public List<Developer> getDevelopers() {
		return service.getAllDevelopers();
	}
	
	@GetMapping("/developers/{developerId}")
	public Developer getDeveloper(@PathVariable Long developerId) {
		return service.getDeveloperById(developerId);
	}
	
	@PostMapping("/developers")
	public Developer createDeveloper(@RequestBody Developer developer) {
		return service.save(developer);
	}
	
	@PutMapping("/developers/{developerId}")
	public Developer updateDeveloper(@PathVariable Long developerId, @RequestBody Developer developer) {
		return service.update(developerId, developer);
	}
	
	@DeleteMapping("/developers/{developerId}")
	public Developer deleteDeveloper(@PathVariable Long developerId) {
		return service.delete(developerId);
	}
}
