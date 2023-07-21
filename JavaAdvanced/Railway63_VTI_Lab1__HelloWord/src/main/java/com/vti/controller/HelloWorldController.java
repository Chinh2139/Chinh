package com.vti.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "ap1/v1/helloworld")
@CrossOrigin("*")

public class HelloWorldController {
	@GetMapping()
	public String getHello(@RequestParam(value = "page") String pageParam) {
		String result = "Hello Ken";
		System.out.println("pageParam: " + pageParam);
		return result;
	}

// Path Variable
	// http://localhost:8080/ap1/v1/helloworld/idMobile
	@GetMapping(value = "/{idMobile}")
	public String getHelloByID(@PathVariable(name = "idMobile") String idParam) {
		String result = "Hello Ken";
		System.out.println("idParam: " + idParam);

		return result;

	}
	//http://localhost:8080/ap1/v1/helloworld/helloNew
	@GetMapping(value = "/helloNew")
	public String getHelloNew() {
		String result = "Hello New";
		return result;
	}
}