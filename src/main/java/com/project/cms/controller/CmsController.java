package com.project.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cms.model.Login;
import com.project.cms.model.User;
import com.project.cms.service.CmsService;
import com.project.cms.web.dto.CmsUserRegistrationDto;

@RestController
@RequestMapping(value = "/v1/cms")
public class CmsController {
	
	@Autowired
	private CmsService cmsService;

	@PostMapping(value = "/signup")
	public ResponseEntity<User> userSignUp(@RequestBody CmsUserRegistrationDto registationDto) {
		return ResponseEntity.ok(cmsService.save(registationDto));
		
	}
	
	@PostMapping(value = "/login")
	public UserDetails login(@RequestBody Login loginDto) {
		return cmsService.loadUserByUsername(loginDto.getEmail());
	}

}
