package br.com.moisesestevao.api.mensagens.domain.form;

import br.com.moisesestevao.api.mensagens.application.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    private String nome;
    private String email;
    private String senha;

    public static boolean valida(UserForm form, UserRepository userRepository) {
        if(form.email!= null && form.nome != null && form.senha != null){
            return userRepository.findByUsername(form.email).isEmpty();
        }
        return false;
    }
}
