package com.project.cms.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Login {
	
	private String email;
	private String password;

}
