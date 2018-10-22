package com.self.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;


public class MyApp {
	private static final Logger  log = LoggerFactory.getLogger(MyApp.class);
	
	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		RandomQuote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", RandomQuote.class);
		log.info(quote.toString());
	}
	
}
