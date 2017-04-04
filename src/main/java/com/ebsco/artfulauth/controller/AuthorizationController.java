package com.ebsco.artfulauth.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ebsco.artfulauth.services.AuthorizationService;
import com.ebsco.artfulauth.value.AuthVO;
import com.ebsco.artfulauth.value.UserVO;


@RestController
@RequestMapping("/authorization")
public class AuthorizationController {

	@Autowired
	private AuthorizationService authService;
	
	@RequestMapping(method = RequestMethod.GET, path ="{id}")
	public UserVO getById(@PathVariable(name = "id", required = true) Integer id) {
		return authService.getById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path ="")
	public UserVO createUser(@RequestBody(required = true) UserVO uservo) {
		return authService.createUser(uservo);
	}
	
	@RequestMapping(method = RequestMethod.POST, path ="{id}")
	public UserVO updateUser(@PathVariable(name = "id", required = true) Integer id, @RequestBody(required = true) UserVO uservo) {
		return authService.updateUser(id, uservo);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path ="{id}")
	public UserVO deleteById(@PathVariable(name = "id", required = true) Integer id) {
		return authService.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, path ="login")
	public AuthVO login(@RequestBody(required = true) UserVO uservo, HttpServletRequest request, HttpServletResponse response) {
		final Logger logger = LoggerFactory.getLogger(this.getClass());
		if(!authService.login(uservo)){
			logger.info("Login credentials invalid");
			response.setStatus( HttpServletResponse.SC_UNAUTHORIZED  );
			return new AuthVO();
		}
		else{
			logger.info("User " + uservo.getUsername() + " Authorized");
			response.setStatus( HttpServletResponse.SC_OK );
			return new AuthVO(uservo.getUsername(), UUID.randomUUID().toString());
		}
	}
	
	@RestController
	public class SimpleController {
	   private final Logger logger = LoggerFactory.getLogger(this.getClass());
	   @RequestMapping("/")
	   String hello(){
	       logger.debug("Debug message");
	       logger.info("Info message");
	       logger.warn("Warn message");
	       logger.error("Error message");
	       return "Done";
	   }
	}
}
