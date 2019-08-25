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
		
		Usuario usuarioRetornado;
		
		// userRepository.buscaPorLoginESenha(usuario);
		usuarioRetornado = userRepository.buscaPorLoginESenha(usuario.getLogin(), usuario.getSenha());
		
		if (usuarioRetornado != null) {
			usuarioRetornado.setToken(UUID.randomUUID().toString().toUpperCase());
			userRepository.saveAndFlush(usuarioRetornado);
		}
		
		return usuarioRetornado;
	}

	@RequestMapping(value = "/usuario/{id}")
	public Optional<Usuario> encontraPeloId(@PathVariable Long id){
		return userRepository.findById(id);
	}
	
	@RequestMapping(value = "/usuario/nome/{nome}")
	public Usuario encontraPeloNome(@PathVariable String nome){
		Usuario usuario = new Usuario();   // userRepository.usuarioPeloNome(nome); 
		if(usuario != null) {
			return usuario;
		}
		return new Usuario();
	}
	
	
	@RequestMapping(value = "/usuario/{id}/deleta")
	public String deleta(@PathVariable Long id){
		Optional<Usuario> usuario = userRepository.findById(id);
		if (usuario != null) {
			userRepository.deleteById(id);
			return "User deletado com sucesso";
		}
		return "Não foi possível deletar porque o usuario não existe"; 
	}
	
	@RequestMapping(value = "/listarUsers")
	public List<Usuario> listarUsers() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		//usuarios = userRepository.findAll();
		return usuarios;
	}
}
