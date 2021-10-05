package com.monka.potal.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Api {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String title;
	
	private String description;
	
	@OneToMany
	private List<ApiGroup> apiGroups;
	
	@OneToMany
	private List<AudienceGroup> audienceGroups;
}
