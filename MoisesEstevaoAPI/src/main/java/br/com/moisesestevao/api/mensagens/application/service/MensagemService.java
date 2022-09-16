package br.com.moisesestevao.api.mensagens.application.service;

import br.com.moisesestevao.api.mensagens.domain.form.MensagemForm;
import br.com.moisesestevao.api.mensagens.domain.model.Mensagem;
import br.com.moisesestevao.api.mensagens.application.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Service
public class MensagemService {
    @Autowired
    SpamService spamService;
    @Autowired
    MensagemRepository repository;
    @Autowired
    EmailService emailService;

    public Mensagem save(@Valid MensagemForm form, HttpServletRequest request){
        if(this.spamService.validate(request)){
            Mensagem mensagem = new Mensagem(form);
            Integer response = this.emailService.send(
                    mensagem.getEmail(),
                    mensagem.getNome(),
                    mensagem.getAssunto(),
                    mensagem.getMensagem()
            );
            if(response == 0) return repository.save(mensagem);
        }
        return null;
    }

}
