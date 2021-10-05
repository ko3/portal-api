package com.monka.potal.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.monka.potal.api.model.Organization;
import com.monka.potal.api.repository.OrganizationRepository;

@Service
public class OrganizationService {

	private final OrganizationRepository repository;
	
	public OrganizationService(OrganizationRepository organizationRepository) {
		this.repository = organizationRepository;
	}
	
	public List<Organization> getOrgs(){
		List<Organization> orgs = new ArrayList<>();
		repository.findAll().forEach(entity -> orgs.add(map(entity)));
		return orgs;
		
	}
	
	public Organization getOrgById(Long orgId) {
		return map(repository.findById(orgId).orElse(new com.monka.potal.api.entity.Organization()));
	}
	
	public Organization save(Organization org) {
		return map(repository.save(map(org)));
	}
	
	public Organization update(Long orgId, Organization org) {
		//org.setId()
		org.setId(orgId);
		return map(repository.save(map(org)));
	}
	
	public void delete(Long orgId) {
		repository.deleteById(orgId);
	}
	
	private Organization map(com.monka.potal.api.entity.Organization source) {
		Organization target = new Organization();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		
		
		return target;		
	}
	
	private com.monka.potal.api.entity.Organization map(Organization source) {
		com.monka.potal.api.entity.Organization target = new com.monka.potal.api.entity.Organization();
		target.setId(source.getId());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		
		return target;		
	}
}
