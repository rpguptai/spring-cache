package com.versh.utils;

import org.springframework.stereotype.Component;

@Component
public interface DataRead {
	public String getID(String input);
	public String getAddress(String input);
}
