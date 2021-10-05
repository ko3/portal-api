package com.monka.potal.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monka.potal.api.model.Response;

@RestController
public class GetStartedController {

	@GetMapping("/get-started")
	public Response getStarted() {
		return new Response();
	}
}
