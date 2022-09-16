package br.com.moisesestevao.api.mensagens.application.repository;

import br.com.moisesestevao.api.mensagens.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String email);
}
