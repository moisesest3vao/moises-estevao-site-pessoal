package br.com.moisesestevao.api.mensagens.domain.dto;

import br.com.moisesestevao.api.mensagens.domain.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String nome;
    private String username;

    public UserDto(User usuario) {
        this.nome = usuario.getNome();
        this.username = usuario.getUsername();
    }
}
