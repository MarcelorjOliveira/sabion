package br.com.sabion.client.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		if(id != 0) {
			this.id = id;
		}
	}
	
	private String login;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login != null) {
			this.login = login;
		}
	}
	
	private String senha;	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha != null) {
			this.senha = senha;
		}
	}

	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		if(token != null) {
			this.token = token;
		}
	}
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null) {
			this.nome = nome;
		}
	}
	
	private String marca;

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		if(marca != null) {
			this.marca = marca;
		}
	}

	private String atividades;
	
	public String getAtividades() {
		return atividades;
	}
	public void setAtividades(String atividades) {
		if(atividades != null) {
			this.atividades = atividades;
		}
	}

	private String contatos;	
	
	public String getContatos() {
		return contatos;
	}
	public void setContatos(String contatos) {
		if(contatos != null) {
			this.contatos = contatos;
		}
	}

 	private Date dataCadastro;
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	private String whatsapp;
	
	public String getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(String whatsapp) {
		if(whatsapp != null) {
			this.whatsapp = whatsapp;
		}
	}

	private String facebook;
	
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		if(facebook != null) {
			this.facebook = facebook;
		}
	}

	private String instagram;	
	
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		if(instagram != null) {
			this.instagram = instagram;
		}
	}
	
	public static String initialDirectory = "/usr/local/tomcat/users/";
	
}
