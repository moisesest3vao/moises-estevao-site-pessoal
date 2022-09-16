package br.com.moisesestevao.api.mensagens.domain.dto;

import br.com.moisesestevao.api.mensagens.domain.model.Mensagem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemDto {
    private Long id;
    private String telefone;
    private String email;
    private String nome;
    private String assunto;
    private String mensagem;
    public MensagemDto(Mensagem mensagem) {
        this.id = mensagem.getId();
        this.nome = mensagem.getNome();
        this.assunto = mensagem.getAssunto();
        this.mensagem = mensagem.getMensagem();
        this.email = mensagem.getEmail();
    }
}
