package com.versh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RefreshService {
	
	@Autowired
	private DataService dataService;
	
	
	@Autowired
	CacheManager CacheManager; // for future use
	
	@Scheduled(fixedRate = 60000)
	@CacheEvict(cacheNames ="person", allEntries = true, beforeInvocation = true )
	public void refreshValues() {
		log.info(" ************* Data Refresh is being called ***************");
		refreshID();
		refreshAddress();
	}
	
	@Cacheable(value="person", key="'name'")
	public String refreshID() {
		return dataService.getID("Refresh");
	}

	@Cacheable(value="person", key="'address'")
	public String refreshAddress() {
		return dataService.getAddress("Refresh");
	}
	
}
