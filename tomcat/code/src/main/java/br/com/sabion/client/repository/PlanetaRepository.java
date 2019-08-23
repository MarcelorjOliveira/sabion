package br.com.sabion.client.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sabion.client.model.Planeta;
/*
import org.springframework.data.cassandra.repository.CassandraRepository;
public interface PlanetaRepository extends CassandraRepository<Planeta, Integer> {
}
*/
@ComponentScan
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {
	
	@Query("SELECT p FROM Planeta p WHERE p.nome = ?1")
	public Planeta planetaPeloNome(String nome);
	
}
