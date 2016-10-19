package com.kasisripriyawebapps.myindia.configs;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.ext.Provider;

import org.springframework.core.annotation.Order;

@Provider
@Order(1)
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

		requestContext.setProperty("access_token", accessToken);
		System.out.println("accessToken>>>>>>>>" + accessToken+requestContext.getUriInfo().getRequestUri().toString());
	}
}
