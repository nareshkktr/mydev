package com.kasisripriyawebapps.myindia.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class OAuthUser extends User implements UserDetails {

	public OAuthUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

	public OAuthUser(User user) {
		super(user.getUsername(), user.getPassword(), user.getAuthorities());
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -899181106441130519L;

}
