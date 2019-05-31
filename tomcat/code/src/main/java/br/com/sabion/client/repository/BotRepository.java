package br.com.sabion.client.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sabion.client.model.Bot;

@RepositoryRestResource(collectionResourceRel = "bots", path = "bots")
public interface BotRepository extends CrudRepository<Bot, Long> {
	
}
