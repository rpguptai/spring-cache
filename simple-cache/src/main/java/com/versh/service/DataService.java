package com.versh.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.versh.utils.DataRead;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataService {
	
	@Autowired
	DataRead dataRead;	
	
	@Cacheable(value="person", key="'name'")
	public String getID(String input) {		
		return dataRead.getID(input);
	}
	
	@Cacheable(value="person", key="'address'")
	public String getAddress(String input) {
		return dataRead.getAddress(input);
	}

}
