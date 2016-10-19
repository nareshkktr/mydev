package com.kasisripriyawebapps.myindia.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import com.kasisripriyawebapps.myindia.serviceimpl.CustomUserDetailsService;

@Configuration
public class OAuth2SecurityConfiguration {

	private static final String REALM = "MY_OAUTH_REALM";
	private static final String RESOURCE_ID = "MyIndiaAppRestAPI";

	@Configuration
	@EnableResourceServer
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) {
			resources.resourceId(RESOURCE_ID).stateless(false);
		}

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.anonymous().disable().requestMatchers().antMatchers("/api/*/*").and().authorizeRequests()
					.antMatchers("/api/*/*").access("hasRole('USER')").and().exceptionHandling()
					.accessDeniedHandler(new OAuth2AccessDeniedHandler());
		}
	}

	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

		private TokenStore tokenStore = new InMemoryTokenStore();

		@Autowired
		@Qualifier("authenticationManagerBean")
		private AuthenticationManager authenticationManager;

		@Autowired
		private CustomUserDetailsService customUserDetailsService;

		@Value("${oauth.client_id}")
		private String clientId;

		@Value("${oauth.client_secret}")
		private String clientSecret;

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
			endpoints.tokenStore(this.tokenStore).authenticationManager(this.authenticationManager)
					.userDetailsService(customUserDetailsService);
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

			clients.inMemory().withClient(clientId)
					.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
					.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT").scopes("read", "write", "trust")
					.secret(clientSecret).accessTokenValiditySeconds(120).refreshTokenValiditySeconds(600);
		}

		@Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			DefaultTokenServices tokenServices = new DefaultTokenServices();
			tokenServices.setSupportRefreshToken(true);
			tokenServices.setTokenStore(this.tokenStore);
			return tokenServices;
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
			oauthServer.realm(REALM + "/client");
		}

	}
}
