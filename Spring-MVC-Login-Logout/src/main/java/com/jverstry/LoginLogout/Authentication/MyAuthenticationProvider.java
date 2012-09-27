
package com.jverstry.LoginLogout.Authentication;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class MyAuthenticationProvider implements AuthenticationProvider {
	
	private static final List<GrantedAuthority> AUTHORITIES
		= new ArrayList<GrantedAuthority>();

	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
	}

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		
		if (auth.getName().equals(auth.getCredentials())) {
			return new UsernamePasswordAuthenticationToken(auth.getName(),
				auth.getCredentials(), AUTHORITIES);
		}
		
		throw new BadCredentialsException("Bad Credentials");
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		if ( authentication == null ) return false;
		return Authentication.class.isAssignableFrom(authentication);
		
	}
  
}