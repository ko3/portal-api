package com.monka.potal.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.monka.potal.api.model.Contactus;
import com.monka.potal.api.model.Response;

@RestController
public class ContactusController {

	@PostMapping("/contact-us")
	public Response contact(@RequestBody Contactus contactus) {
		
		return new Response();
	}
}
