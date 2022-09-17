package br.com.moisesestevao.api.mensagens.service;

import br.com.moisesestevao.api.mensagens.application.service.SpamService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;

public class SpamServiceTest {
    private SpamService spamService;
    @Mock
    private HttpServletRequest request;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
        this.spamService = new SpamService();
    }

    @Test
    void deveriaBloquearOAcessoEmCasoDeSpam(){
        Mockito.when(this.request.getRemoteAddr()).thenReturn("000.000.000.000");
        Boolean firstValidation = spamService.validate(request);
        Boolean secondValidation = spamService.validate(request);

        Assertions.assertTrue(firstValidation);
        Assertions.assertFalse(secondValidation);
    }
}
