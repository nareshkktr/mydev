package com.kasisripriyawebapps.myindia.serviceimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.entity.Account;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Value("${oath.get_account_details_by_user_name}")
	private String getAccountDetailsByUserName;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Account account = jdbcTemplate.queryForObject(getAccountDetailsByUserName, new Object[] { userName },
				new RowMapper<Account>() {
					@Override
					public Account mapRow(ResultSet resultSet, int i) throws SQLException {
						Account account = new Account();
						account.setGuid(resultSet.getLong("ACCOUNT_GUID"));
						account.setUserName(resultSet.getString("USER_NAME"));
						account.setPassword(resultSet.getString("PASSWORD"));
						return account;
					}
				});

		if (account == null) {
			throw new UsernameNotFoundException(String.format("User %s does not exist!", userName));
		}
		return new AccountRepositoryUserDetails(account);
	}

	private final static class AccountRepositoryUserDetails extends Account implements UserDetails {

		private static final long serialVersionUID = 1L;

		private AccountRepositoryUserDetails(Account account) {
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
}
