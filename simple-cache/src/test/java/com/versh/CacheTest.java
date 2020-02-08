package com.versh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.concurrent.TimeUnit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.versh.service.DataService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CacheTestApp.class})
@ActiveProfiles("UNIT")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CacheTest {

	@Autowired
	DataService dataService;
	
	private static String name;
	private static String address;
	
	@Test
	public void testA() {
		name = dataService.getID("FROM Junit");
		address = dataService.getAddress("FROM Junit");		
		assertEquals(name, dataService.getID("FROM assert"));
		assertEquals(address, dataService.getAddress("FROM assert"));
		
	}
	
	@Test
	public void testB() throws InterruptedException{
		TimeUnit.SECONDS.sleep(10);	
		assertEquals(name, dataService.getID("FROM assert"));
		assertEquals(address, dataService.getAddress("FROM assert"));
		
	}
	
	@Test
	public void testC() throws InterruptedException{
		TimeUnit.MINUTES.sleep(2);		
		assertNotEquals(name, dataService.getID("FROM assert"));
		assertNotEquals(address, dataService.getAddress("FROM assert"));
		
	}
	
	
	
	
	
}
