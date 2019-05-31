package br.com.sabion.client.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
public class Mensagem{

	public Mensagem() {
		
	}
	
	public Mensagem(String texto) {
		this.texto = texto;
	}
	
	public Mensagem(String texto, Bot bot) {
		this.texto = texto;
		this.bot = bot;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	    
	@ManyToOne
    @JoinColumn(name = "botId")
	@RestResource(path = "botMensagem", rel="mensagem")
    private Bot bot;
	
	public Bot getBot() {
		return bot;
	}

	public void setBot(Bot bot) {
		this.bot = bot;
	}

}
