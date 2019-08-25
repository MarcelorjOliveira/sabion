package br.com.sabion.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sabion.client.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.login = ?1 and u.senha = ?2 ")
	public Usuario buscaPorLoginESenha(String login, String senha);

	@Query("SELECT u FROM Usuario u WHERE u.login = ?1")
	public Usuario buscaLogin(String login);
}

