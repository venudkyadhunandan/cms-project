package com.project.cms.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.cms.model.User;
import com.project.cms.web.dto.CmsUserRegistrationDto;


public interface CmsService extends UserDetailsService{
	
	User save(CmsUserRegistrationDto registrationDto);

}
