package br.com.sabion.client.repository;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.sabion.client.model.Mensagem;

//@RepositoryRestResource(collectionResourceRel = "mensagens", path = "mensagens")
public interface MensagemRepository extends CrudRepository<Mensagem, Long> {
	
}
