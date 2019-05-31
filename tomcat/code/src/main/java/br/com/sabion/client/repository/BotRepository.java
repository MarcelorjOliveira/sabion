package br.com.sabion.client.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.sabion.client.model.Bot;

public interface BotRepository extends CrudRepository<Bot, Long> {
	
}
