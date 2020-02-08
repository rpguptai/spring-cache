package com.versh;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.versh.utils.DataRead;

@Component
@Profile({"UNIT"})
public class DataReadTestImpl implements DataRead{

	@Override
	public String getID(String input) {
		// TODO Auto-generated method stub
		
		int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString);
		return generatedString;
	}

	@Override
	public String getAddress(String input) {
		int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = true;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		System.out.println(generatedString);
		return generatedString;
	}

}
