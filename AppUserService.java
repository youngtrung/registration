package com.example.registration.appuser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
	
	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
	private AppUserRepository appUserRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return appUserRepository.findByEmail(email).orElseThrow(() -> 
		new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
	}

}
