package br.com.moisesestevao.api.mensagens.service;

import br.com.moisesestevao.api.mensagens.application.repository.MensagemRepository;
import br.com.moisesestevao.api.mensagens.application.service.EmailService;
import br.com.moisesestevao.api.mensagens.application.service.MensagemService;
import br.com.moisesestevao.api.mensagens.application.service.SpamService;
import br.com.moisesestevao.api.mensagens.domain.form.MensagemForm;
import br.com.moisesestevao.api.mensagens.domain.model.Mensagem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import javax.servlet.http.HttpServletRequest;

public class MensagemServiceTest {
    private MensagemService mensagemService;
    @Mock
    SpamService spamService;
    @Mock
    EmailService emailService;
    @Mock
    HttpServletRequest servletRequest;
    @Mock
    MensagemRepository mensagemRepository;
    @Captor
    private ArgumentCaptor<Mensagem> captor;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.mensagemService = new MensagemService(this.spamService, this.mensagemRepository, this.emailService);
    }

    @Test
    void deveriaSalvarAMensagem(){
        MensagemForm form = new MensagemForm();
        form.setMensagem("mensagem de teste");
        form.setNome("nome teste");
        form.setEmail("email@email.com");
        form.setAssunto("assunto de teste");

        Mensagem mensagem = new Mensagem(form);

        Mockito.when(this.spamService.validate(this.servletRequest)).thenReturn(true);
        Mockito.when(this.emailService.send(
                    mensagem.getEmail(),
                    mensagem.getNome(),
                    mensagem.getAssunto(),
                    mensagem.getMensagem())
                        ).thenReturn(0);
        Mockito.when(this.mensagemRepository.save(ArgumentMatchers.any())).thenReturn(new Mensagem(form));

        Mensagem save = this.mensagemService.save(form, this.servletRequest);
        Assertions.assertEquals(form.getMensagem(), save.getMensagem());
        Assertions.assertEquals(form.getEmail(), save.getEmail());
        Assertions.assertEquals(form.getNome(), save.getNome());
        Assertions.assertEquals(form.getAssunto(), save.getAssunto());
    }
}
