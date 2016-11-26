package com.kasisripriyawebapps.myindia.configs;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class AuthenticationRequestFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String accessToken = null;
		for (Cookie c : requestContext.getCookies().values()) {
			if (c.getName().equals("access_token")) {
				if (c.getValue() != null && !c.getValue().isEmpty()) {
					accessToken = c.getValue();
				}
				break;
			}
		}
		System.out.println("accessToken>>>" + accessToken);
		requestContext.getHeaders().add("Authorization", "Bearer " + accessToken);
	}
}
