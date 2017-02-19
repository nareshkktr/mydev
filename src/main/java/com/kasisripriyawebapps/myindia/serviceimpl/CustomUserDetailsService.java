package com.kasisripriyawebapps.myindia.serviceimpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kasisripriyawebapps.myindia.configs.LoggedInUserDetails;
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
		return new LoggedInUserDetails(account);
	}
}
