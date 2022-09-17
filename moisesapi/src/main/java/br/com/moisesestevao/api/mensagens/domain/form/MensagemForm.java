package br.com.moisesestevao.api.mensagens.domain.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class MensagemForm {

    @NotNull @NotBlank @Size(max = 70)
    private String email;
    @NotNull @NotBlank @Size(max = 100)
    private String nome;
    @NotNull @NotBlank @Size(max = 100)
    private String assunto;
    @NotNull @NotBlank @Size(max = 650)
    private String mensagem;
}
