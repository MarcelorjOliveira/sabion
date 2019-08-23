package br.com.sabion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabion.client.model.Planeta;
import br.com.sabion.client.repository.PlanetaRepository;

@RestController
public class PlanetaController {

	@Autowired
	private PlanetaRepository planetaRepository;

	@CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8787"},
     maxAge = 4800, allowCredentials = "false") 	@RequestMapping(value = "/planetaTeste")
	public Planeta planetas() {
		Planeta planeta = new Planeta("nome1", "usuario1", "terreno1" );
		planetaRepository.save(planeta);
		return planeta;

	}
	@PostMapping(value="/planeta")
	public Planeta adicionarPlaneta(@RequestBody Planeta planeta) {
		return planetaRepository.save(planeta);
	}
	
	@RequestMapping(value = "/planeta/{id}")
	public Optional<Planeta> encontraPeloId(@PathVariable Long id){
		return planetaRepository.findById(id);
	}
	
	@RequestMapping(value = "/planeta/nome/{nome}")
	public Planeta encontraPeloNome(@PathVariable String nome){
		Planeta planeta = planetaRepository.planetaPeloNome(nome); 
		if(planeta != null) {
			return planeta;
		}
		return new Planeta();
	}
	
	
	@RequestMapping(value = "/planeta/{id}/deleta")
	public String deleta(@PathVariable Long id){
		Optional<Planeta> planeta = planetaRepository.findById(id);
		if (planeta != null) {
			planetaRepository.deleteById(id);
			return "Planeta deletado com sucesso";
		}
		return "Não foi possível deletar porque o planeta não existe"; 
	}
	
	
	@RequestMapping(value = "/listarPlanetas")
	public List<Planeta> listarPlanetas() {
		List<Planeta> planetas = new ArrayList<Planeta>();
		planetas = planetaRepository.findAll();
		return planetas ;
	}
}
