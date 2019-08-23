package br.com.sabion.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sabion.client.model.Bot;

public interface BotRepository extends JpaRepository<Bot, Long> {
	
}
