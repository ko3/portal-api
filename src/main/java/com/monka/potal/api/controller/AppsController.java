package com.monka.potal.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monka.potal.api.model.App;
import com.monka.potal.api.service.AppService;

@RestController
public class AppsController {
	
	private final AppService service;
	
	public AppsController(AppService service) {
		this.service = service;
	}

	@GetMapping("/apps")
	public List<App> getApps() {
		return service.getAll();
	}
	
	@GetMapping("/apps/{appId}")
	public App getApp(@PathVariable Long appId) {
		return service.getApp(appId);
	}
	
	@PostMapping("/apps")
	public App createApp(@RequestBody App app) {
		return service.save(app);
	}
	
	@PutMapping("/apps/{appId}")
	public App updateApp(@PathVariable Long appId, @RequestBody App app) {
		return service.update(appId, app);
	}
	
	@DeleteMapping("/apps/{appId}")
	public App deleteApp(@PathVariable Long appId) {
		return service.delete(appId);
	}
}
