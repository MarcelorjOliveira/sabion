package br.com.sabion.client.model;

public class Imagem {
	private long id;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		if(id != 0) {
			this.id = id;
		}
	}

	private String conteudo;
	
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

}
