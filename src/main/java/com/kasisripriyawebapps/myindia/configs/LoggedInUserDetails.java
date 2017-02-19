package com.kasisripriyawebapps.myindia.configs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kasisripriyawebapps.myindia.entity.Account;

public class LoggedInUserDetails extends Account implements UserDetails {
	private static final long serialVersionUID = 1L;

	public LoggedInUserDetails(Account account) {
		super(account);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();

		GrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_USER");
		auths.add(auth1);
		return auths;
	}

	@Override
	public String getUsername() {
		return getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
