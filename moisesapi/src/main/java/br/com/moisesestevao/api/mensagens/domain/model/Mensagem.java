package br.com.moisesestevao.api.mensagens.domain.model;

import br.com.moisesestevao.api.mensagens.domain.form.MensagemForm;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Mensagem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String email;
    private String nome;
    private String assunto;
    @Size(max = 650)
    private String mensagem;

    public Mensagem(){

    }


    public Mensagem(MensagemForm form) {
        this.email = form.getEmail();
        this.nome = form.getNome();
        this.assunto = form.getAssunto();
        this.mensagem = form.getMensagem();
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", assunto='" + assunto + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
