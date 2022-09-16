package br.com.moisesestevao.api.auth.infra.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import br.com.moisesestevao.api.auth.infra.service.TokenService;
import br.com.moisesestevao.api.mensagens.domain.model.User;
import br.com.moisesestevao.api.mensagens.application.repository.UserRepository;

public class TokenAuthenticationFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UserRepository userRepository;
	
	public TokenAuthenticationFilter(TokenService tokenService, UserRepository userRepository) {
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getToken(request);
		if(tokenService.isTokenValid(token)) {
			authenticateUser(token);
		}
		filterChain.doFilter(request, response);
	}
	
	private void authenticateUser(String token) {
		User currentUser = userRepository.findById(tokenService.getUserId(token)).get();
		SecurityContextHolder
			.getContext()
			.setAuthentication(
				new UsernamePasswordAuthenticationToken(
						currentUser,
						null,
						currentUser.getAuthorities()			
		));
	}

	private String getToken(HttpServletRequest request){
		String authorization = request.getHeader("Authorization");
		
		if(authorization == null || authorization.isEmpty() || !authorization.startsWith("Bearer ")) {
			return null;
		}
		return authorization.substring(7, authorization.length());
	}
}
