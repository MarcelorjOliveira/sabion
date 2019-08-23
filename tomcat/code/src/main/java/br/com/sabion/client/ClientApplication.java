package br.com.sabion.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"br.com.sabion.controller", "br.com.sabion.client"})
public class ClientApplication {


	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	/*
		repository.deleteAll();

		repository.save(new Planeta("nome", "clima", "terreno"));
		repository.save(new Planeta("Marte", "frio", "seco"));

		System.out.println("Planetas found with findAll():");
		System.out.println("-------------------------------");
		for (Planeta planeta : repository.findAll()) {
			System.out.println(planeta);
		}
	*/

}
