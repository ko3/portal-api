package com.monka.potal.api.model;

import java.util.List;

import lombok.Data;

@Data
public class Organization {

	private Long id;

	private String name;

	private String description;

	private List<Team> teams;

}
