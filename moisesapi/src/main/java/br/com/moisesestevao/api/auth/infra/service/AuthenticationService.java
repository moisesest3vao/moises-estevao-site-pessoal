package br.com.moisesestevao.api.auth.infra.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.moisesestevao.api.mensagens.domain.model.User;
import br.com.moisesestevao.api.mensagens.application.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userRepository.findByUsername(username);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new UsernameNotFoundException("Invalid credentials");
	}
}


