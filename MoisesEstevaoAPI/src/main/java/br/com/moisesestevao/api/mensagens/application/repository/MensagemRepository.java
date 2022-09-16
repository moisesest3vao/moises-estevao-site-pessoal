package br.com.moisesestevao.api.mensagens.application.repository;

import br.com.moisesestevao.api.mensagens.domain.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
