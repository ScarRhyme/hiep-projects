package com.report.oauth.controller;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.controller.BaseController;
import com.report.user.dao.UserDAO;

@RestController
public class OauthController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(OauthController.class);

	@Autowired
	private UserDAO sysUserDAO;

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON)
	public String home() {
		logger.info("Oauth2 APIs!");
		return " Project: Oauth2 APIs\n Name: It's working";
	}

//	@GetMapping("/permission")
//	public @ResponseBody Response permissionOfUser(OAuth2Authentication princal) {
//		return Response.success().withData(sysUserDAO.getAuthorities(princal.getName()));
//	}
}
