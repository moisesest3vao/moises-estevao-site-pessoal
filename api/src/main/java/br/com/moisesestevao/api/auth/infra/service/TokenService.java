package br.com.moisesestevao.api.auth.infra.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.moisesestevao.api.mensagens.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	@Value("${forum.jwt.expiration}")
	private String expirationTime;
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public String generateToken(Authentication authentication) {
		User thisUser = (User) authentication.getPrincipal();
		return Jwts.builder()
				.setIssuer("moisesestevao API")
				.setSubject(thisUser.getId().toString())
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + Long.parseLong(expirationTime)))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

	public boolean isTokenValid(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getUserId(String token) {
		Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());
	}

}
