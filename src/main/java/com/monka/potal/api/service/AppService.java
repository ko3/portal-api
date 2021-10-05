package com.monka.potal.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monka.potal.api.model.App;
import com.monka.potal.api.repository.AppRepository;

@Service
public class AppService {
	
private final AppRepository appRepository;
	
	public AppService(AppRepository appRepository) {
		this.appRepository = appRepository;
	}
	
	public List<App> getAll(){
		List<App> apis = new ArrayList<>(); 
		appRepository.findAll().forEach(apiEntity -> {
			apis.add(map(apiEntity));
		});
		return apis;
	}
	
	public App getApp(Long appId){
		return map(appRepository.findById(appId).orElse(new com.monka.potal.api.entity.App()));
	}
	
	public App save(App app){
		return map(appRepository.save(map(app)));
	}
	
	public App update(Long appId, App app){
		//app.setId();
		return map(appRepository.save(map(app)));
	}
	
	public App delete(Long appId){
		Optional<com.monka.potal.api.entity.App> opt = appRepository.findById(appId);
		App api;
		if(opt.isPresent()) {
			api =  map(opt.get());
			appRepository.deleteById(appId);
		} else {
			api =  new App();
		}
		return api;
	}
	
	private App map(com.monka.potal.api.entity.App source) {
		App target = new App();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		return target;
	}
	
	private com.monka.potal.api.entity.App map(App source) {
		com.monka.potal.api.entity.App target = new com.monka.potal.api.entity.App();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		return target;
	}

}
