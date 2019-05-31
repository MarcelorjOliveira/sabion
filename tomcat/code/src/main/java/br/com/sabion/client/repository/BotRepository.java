package br.com.sabion.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/*
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PlanetaRepository extends CassandraRepository<Planeta, Integer> {

}
*/

import br.com.sabion.client.model.Bot;

public interface BotRepository extends JpaRepository<Bot, Long> {
	
}
