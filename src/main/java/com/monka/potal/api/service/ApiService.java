package com.monka.potal.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monka.potal.api.model.Api;
import com.monka.potal.api.repository.ApiRepository;

@Service
public class ApiService {

	private final ApiRepository apiRepository;
	
	public ApiService(ApiRepository apiRepository) {
		this.apiRepository = apiRepository;
	}
	
	public List<Api> getAll(){
		List<Api> apis = new ArrayList<>(); 
		apiRepository.findAll().forEach(apiEntity -> {
			apis.add(map(apiEntity));
		});
		return apis;
	}
	
	public Api getApi(Long apiId){
		return map(apiRepository.findById(apiId).orElse(new com.monka.potal.api.entity.Api()));
	}
	
	public Api save(Api api){
		return map(apiRepository.save(map(api)));
	}
	
	public Api update(Long apiId, Api api){
		api.setId(apiId);
		return map(apiRepository.save(map(api)));
	}
	
	public Api delete(Long apiId){
		Optional<com.monka.potal.api.entity.Api> opt = apiRepository.findById(apiId);
		Api api;
		if(opt.isPresent()) {
			api =  map(opt.get());
			apiRepository.deleteById(apiId);
		} else {
			api =  new Api();
		}
		return api;
	}
	
	private Api map(com.monka.potal.api.entity.Api source) {
		Api target = new Api();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setTitle(source.getTitle());
		target.setDescription(source.getDescription());
		return target;
	}
	
	private com.monka.potal.api.entity.Api map(Api source) {
		com.monka.potal.api.entity.Api target = new com.monka.potal.api.entity.Api();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setTitle(source.getTitle());
		target.setDescription(source.getDescription());
		return target;
	}
}
