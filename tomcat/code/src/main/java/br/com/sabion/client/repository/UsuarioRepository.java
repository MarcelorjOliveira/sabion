package br.com.sabion.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabion.client.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.login = ?1 and u.senha = ?2 ")
	public Usuario buscaPorLoginESenha(String login, String senha);

	@Query("SELECT u FROM Usuario u WHERE u.login = ?1")
	public Usuario buscaLogin(String login);

	@Query("SELECT u FROM Usuario u WHERE u.token = ?1")

	public Optional<Usuario> findByToken(String token);

}

