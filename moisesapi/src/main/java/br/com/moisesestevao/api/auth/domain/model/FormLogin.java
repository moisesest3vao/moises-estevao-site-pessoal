package br.com.moisesestevao.api.auth.domain.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class FormLogin {
	
	@NotBlank @NotNull
    String username;
	@NotBlank @NotNull
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public UsernamePasswordAuthenticationToken toUsernamePasswordAuthenticationToken() {
		return new UsernamePasswordAuthenticationToken(this.username, this.password);
	}
}
