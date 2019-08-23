package br.com.sabion.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sabion.client.model.Mensagem;

//@RepositoryRestResource(collectionResourceRel = "mensagens", path = "mensagens")
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
	
}
