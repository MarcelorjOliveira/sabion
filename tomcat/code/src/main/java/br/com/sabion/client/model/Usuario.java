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
		this.id = id;
	}
	
	private String login;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	private String senha;	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private String marca;

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	private String atividades;
	
	public String getAtividades() {
		return atividades;
	}
	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}

	private String contatos;	
	
	public String getContatos() {
		return contatos;
	}
	public void setContatos(String contatos) {
		this.contatos = contatos;
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
		this.whatsapp = whatsapp;
	}

	private String facebook;
	
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	private String instagram;	
	
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	
}
