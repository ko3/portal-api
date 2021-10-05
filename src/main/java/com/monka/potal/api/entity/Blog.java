package com.monka.potal.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Blog{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

}
