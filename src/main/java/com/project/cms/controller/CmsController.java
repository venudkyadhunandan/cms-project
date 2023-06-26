package com.project.cms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.cms.model.User;
import com.project.cms.service.CmsService;
import com.project.cms.web.dto.CmsUserRegistrationDto;

@RestController
@RequestMapping(value = "/v1/cms")
public class CmsController {
	
	private CmsService cmsService;

	public CmsController(CmsService cmsService) {
		super();
		this.cmsService = cmsService;
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<User> userSignUp(@RequestAttribute CmsUserRegistrationDto registationDto) {
		return ResponseEntity.ok(cmsService.save(registationDto));
		
	}

}
