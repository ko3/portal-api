package com.monka.potal.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monka.potal.api.model.Api;
import com.monka.potal.api.service.ApiService;

@RestController
public class APIController {
	
	private final ApiService service;
	
	public APIController(ApiService service) {
		this.service = service;
	}

	
	@GetMapping("/apis")
	public List<Api> getApiProducts(){
		return service.getAll();
	}
	
	@GetMapping("/apis/{apiId}")
	public Api getApiProduct(@PathVariable Long apiId){
		return service.getApi(apiId);
	}
	
	@PostMapping("/apis")
	public Api createApi(@RequestBody Api api){
		return service.save(api);
	}
	
	@PutMapping("/apis/{apiId}")
	public Api udpateApi(@PathVariable Long apiId, @RequestBody Api api){
		return service.update(apiId, api);
	}
	
	@DeleteMapping("/apis/{apiId}")
	public Api deleteApi(@PathVariable Long apiId){
		return service.delete(apiId);
	}
}
