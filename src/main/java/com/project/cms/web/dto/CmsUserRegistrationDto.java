package com.project.cms.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CmsUserRegistrationDto {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	

}
