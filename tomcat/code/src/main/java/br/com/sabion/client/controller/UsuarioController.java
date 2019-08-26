package br.com.sabion.client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabion.client.model.Usuario;
import br.com.sabion.client.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository userRepository;

	@RequestMapping(value = "/usuarioTeste")
	public Usuario usuarios() {
		Usuario usuario = new Usuario();
		usuario.setLogin("usuario1");
		usuario.setSenha("terreno1");
		
		userRepository.saveAndFlush(usuario);
		return usuario;

	}
	@PostMapping(value="/usuario/adicionar")
	public Usuario adicionar(@RequestBody Usuario usuario) {
//curl -i -X POST -H "Content-Type:application/json" -d '{"login": "umbot", "senha":"123"}' http://localhost/usuario/adicionar
		Usuario usuarioRetornado = userRepository.buscaLogin(usuario.getLogin());
		if(usuarioRetornado == null) {
			usuario.setToken(null);	
			userRepository.saveAndFlush(usuario);
			
			usuarioRetornado = usuario;
		} else {
			usuarioRetornado = null;
		}
		return usuarioRetornado;
	}
	
	@PostMapping(value="/usuario/logar")
	public Usuario logar (@RequestBody Usuario usuario) {
// curl -i -X POST -H "Content-Type:application/json" -d '{"login": "umbot", "senha":"123"}' http://localhost/usuario/logar
		Usuario usuarioRetornado;
		
		// userRepository.buscaPorLoginESenha(usuario);
		usuarioRetornado = userRepository.buscaPorLoginESenha(usuario.getLogin(), usuario.getSenha());
		
		if (usuarioRetornado != null) {
			usuarioRetornado.setToken(UUID.randomUUID().toString().toUpperCase());
			userRepository.saveAndFlush(usuarioRetornado);
		}
		
		return usuarioRetornado;
	}

	@PostMapping(value = "/usuario/localizar")
	public Usuario localizar(@RequestBody Usuario usuario){
// curl -i -X POST -H "Content-Type:application/json" -d '{"token": "C79CA270-E2DF-49EC-A886-A2B0400CCD75"}' http://localhost/usuario/localizar
		Optional<Usuario> usuarioRetornado = userRepository.findByToken(usuario.getToken());
		if(usuarioRetornado != null) {
			return usuarioRetornado.get();
		} else {
			return new Usuario();
		}
	}
	
	@PostMapping(value = "/usuario/atualizar")
	public Usuario atualizar(@RequestBody Usuario usuario){
// curl -i -X POST -H "Content-Type:application/json" -d '{"token": "C79CA270-E2DF-49EC-A886-A2B0400CCD75"}' http://localhost/usuario/atualiza
		Optional<Usuario> usuarioRetornado = userRepository.findByToken(usuario.getToken());
		if(usuarioRetornado != null) {
			usuario.setId(usuarioRetornado.get().getId());
			userRepository.saveAndFlush(usuario);
		}
		return usuario;
	}
	
	
	@RequestMapping(value = "/listarUsers")
	public List<Usuario> listarUsers() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		//usuarios = userRepository.findAll();
		return usuarios;
	}
}
