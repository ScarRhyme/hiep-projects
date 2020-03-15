package com.apigateway.controller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGatewayController {
	private Logger logger = LoggerFactory.getLogger(ApiGatewayController.class);
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
	public String home() {
		logger.info("Called API Gateway's root API");
		return " Project: APIs Gateway\n Name: it's works";
	}
}
