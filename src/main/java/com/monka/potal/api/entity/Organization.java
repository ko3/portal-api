package com.monka.potal.api.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Organization {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	@OneToMany
	@JoinColumn(name="TEAM_ID", referencedColumnName = "ID")
	private List<Team> teams;
	
	@ManyToMany
	private List<AudienceGroup> audienceGroups;
}
