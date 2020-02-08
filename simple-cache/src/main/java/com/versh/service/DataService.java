package com.versh.service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataService {
	
	@Cacheable(value="person", key="'name'")
	public String getID(String input) {
		log.info(" DATA service getID() is being called from "+input);
		String value = "default";
		
		Path propertyPath=Paths.get("C:\\repo\\test.properties");	
		Reader propReader = null;
		try {
			
			propReader = Files.newBufferedReader(propertyPath);
			Properties appProps = new Properties();
			appProps.load(propReader);
			
			value = appProps.getProperty("NAME");
			
		} catch (Exception e) {
			log.info(" EXCEPTION "+e.getMessage());
		}finally {
			try {
				propReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return value;		
	}
	
	@Cacheable(value="person", key="'address'")
	public String getAddress(String input) {
		log.info(" DATA service getAddress() is being called from "+input);
		String value = "default";
		
		Path propertyPath=Paths.get("C:\\repo\\test.properties");	
		Reader propReader = null;
		try {
			
			propReader = Files.newBufferedReader(propertyPath);
			Properties appProps = new Properties();
			appProps.load(propReader);
			
			value = appProps.getProperty("ADDRESS");
			
		} catch (Exception e) {
			log.info(" EXCEPTION "+e.getMessage());
		}finally {
			try {
				propReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return value;		
	}

}
