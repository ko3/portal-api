package com.monka.potal.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.monka.potal.api.entity.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

}
