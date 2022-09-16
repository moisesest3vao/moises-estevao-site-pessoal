package br.com.moisesestevao.api.auth.api;

import br.com.moisesestevao.api.mensagens.domain.dto.UserDto;
import br.com.moisesestevao.api.mensagens.domain.form.UserForm;
import br.com.moisesestevao.api.mensagens.domain.model.User;
import br.com.moisesestevao.api.mensagens.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> criaUsuario(@RequestBody UserForm form){
        throw new RuntimeException("user registration is not allowed");

//        if(UserForm.valida(form, userRepository)){
//            User usuario = new User(form);
//            userRepository.save(usuario);
//            return ResponseEntity.ok(new UserDto(usuario));
//        }
//        return ResponseEntity.badRequest().build();
    }
}
