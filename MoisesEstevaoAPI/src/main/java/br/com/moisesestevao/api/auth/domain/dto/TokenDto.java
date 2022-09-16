package br.com.moisesestevao.api.auth.domain.dto;

public class TokenDto {
	String token;
	String type;

	public TokenDto(String token, String type) {
		this.token = token;
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
