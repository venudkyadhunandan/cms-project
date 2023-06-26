package com.project.cms.service;

import java.util.Arrays;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.cms.model.Role;
import com.project.cms.model.User;
import com.project.cms.repository.UserRepository;
import com.project.cms.web.dto.CmsUserRegistrationDto;

@Service
public class CmsServiceImpl implements CmsService {
	
	private UserRepository userRepository;
	
	public CmsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(CmsUserRegistrationDto registrationDto) {
		
		if(registrationDto.getPassword().equals(registrationDto.getConfirmPassword())){
		
		User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail()
				,registrationDto.getPassword(),Arrays.asList(new Role("ROLE_User")));
		
		return userRepository.save(user);
		} else {
			throw new RuntimeException("Password and Confirmation Password does not match");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
