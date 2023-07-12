package com.slokam.patient.activities;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppSchedular {
	
	private static Logger LOGGER = LoggerFactory.getLogger(AppSchedular.class); 
	
	//@Scheduled(fixedRate=10 , timeUnit=TimeUnit.SECONDS)
	//@Scheduled(cron="*/10 * * * * * ")
	public void test() {
		
		
		LOGGER.info("Test Method from Schedular");
		
	}

}
