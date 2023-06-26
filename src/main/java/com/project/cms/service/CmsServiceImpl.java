package com.project.cms.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.cms.model.Role;
import com.project.cms.model.User;
import com.project.cms.repository.UserRepository;
import com.project.cms.web.dto.CmsUserRegistrationDto;

@Service
public class CmsServiceImpl implements CmsService {
	
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	public CmsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	

	@Override
	public User save(CmsUserRegistrationDto registrationDto) {
		
		if(registrationDto.getPassword().equals(registrationDto.getConfirmPassword())){
		
		User user = new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail()
				,passwordEncode.encode(registrationDto.getPassword()),Arrays.asList(new Role("ROLE_User")));
		
		return userRepository.save(user);
		} else {
			throw new RuntimeException("Password and Confirmation Password does not match");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

}
