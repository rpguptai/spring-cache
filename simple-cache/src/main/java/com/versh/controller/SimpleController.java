package com.versh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.versh.service.DataService;

@RestController
public class SimpleController {

	@Autowired
	private DataService dataService;
	
	//ex http://localhost:8080/cache/simple/test
	@RequestMapping(value = "/simple/{input}", method = RequestMethod.GET)
	public String getDetails(@PathVariable("input") String input) {
		return dataService.getID(input) +" : "+ dataService.getAddress(input);
	}
	
}
