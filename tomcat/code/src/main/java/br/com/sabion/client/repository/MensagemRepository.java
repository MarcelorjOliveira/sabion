package br.com.sabion.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sabion.client.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	
}
