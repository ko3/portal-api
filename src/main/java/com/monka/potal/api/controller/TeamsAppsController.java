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

import com.monka.potal.api.model.App;

@RestController
public class TeamsAppsController {
	@GetMapping("/teams/{teamId}/apps")
	public List<App> getApps(@PathVariable Long teamId) {
		return new LinkedList<>();
	}
	
	@GetMapping("/teams/{teamId}/apps/{appId}")
	public App getApp(@PathVariable Long teamId, @PathVariable Long appId) {
		return new App();
	}
	
	@PostMapping("/teams/{teamId}/apps")
	public App createApp(@PathVariable Long teamId, @RequestBody App app) {
		return new App();
	}
	
	@PutMapping("/teams/{teamId}/apps/{appId}")
	public App updateApp(@PathVariable Long teamId, @PathVariable Long appId, @RequestBody App app) {
		return new App();
	}
	
	@DeleteMapping("/teams/{teamId}/apps/{appId}")
	public App deleteApp(@PathVariable Long teamId, @PathVariable Long appId) {
		return new App();
	}
}
