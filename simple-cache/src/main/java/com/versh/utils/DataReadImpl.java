package com.versh.utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile({"TEST"})
public class DataReadImpl implements DataRead{

	@Override
	public String getID(String input) {
		log.info(" DATAREAD service getAddress() is being called from "+input);
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

	@Override
	public String getAddress(String input) {
		log.info(" DATAREAD service getAddress() is being called from "+input);
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
