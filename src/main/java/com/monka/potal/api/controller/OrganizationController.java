package com.monka.potal.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monka.potal.api.model.Organization;
import com.monka.potal.api.service.OrganizationService;

@RestController
public class OrganizationController {
	
	private final OrganizationService service;
	
	public OrganizationController(OrganizationService service) {
		this.service = service;
	}
	
	@GetMapping("/organizations")
	public List<Organization> getOrganizations() {
		return service.getOrgs();
	}
	
	@GetMapping("/organizations/{organizationId}")
	public Organization getOrganization(@PathVariable Long organizationId) {
		return service.getOrgById(organizationId);
	}
	
	@PostMapping(value="/organizations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public Organization createOrg(@RequestBody Organization organization) {
		return service.save(organization);
	}
	
	@PutMapping("/organizations/{organizationId}")
	public Organization updateOrg(@PathVariable Long organizationId, @RequestBody Organization organization) {
		return service.update(organizationId, organization);
	}
	
	@DeleteMapping("/organizations/{organizationId}")
	public void deleteOrganization(@PathVariable Long organizationId) {
		 service.delete(organizationId);
	}

}
