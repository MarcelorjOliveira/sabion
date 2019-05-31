package br.com.sabion.client.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabion.client.model.Mensagem;
import br.com.sabion.client.repository.MensagemRepository;

@RestController
public class MensagemController {

	@Autowired
	private MensagemRepository mensagemRepository;

	@RequestMapping(value = "/mensagemTeste")
	public Mensagem planetas() {
		Mensagem mensagem = new Mensagem("nome1");
		mensagemRepository.save(mensagem);
		return mensagem;
	}

	@PostMapping(value = "/mensagem")
	public Mensagem adicionarMensagem(@RequestBody Mensagem mensagem) {
		return mensagemRepository.save(mensagem);
	}

	@RequestMapping(value = "/mensagem/{id}")
	public Optional<Mensagem> encontraPeloId(@PathVariable Long id) {
		return mensagemRepository.findById(id);
	}

	@RequestMapping(value = "/mensagem/{id}/deleta")
	public String deleta(@PathVariable Long id) {
		Optional<Mensagem> mensagem = mensagemRepository.findById(id);
		if (mensagem != null) {
			mensagemRepository.deleteById(id);
			return "Mensagem deletado com sucesso";
		}
		return "Não foi possível deletar porque o mensagem não existe";
	}

	@RequestMapping(value = "/listarMensagens")
	public List<Mensagem> listarMensagens() {
		List<Mensagem> mensagens = new ArrayList<Mensagem>();
		mensagens = mensagemRepository.findAll();
		return mensagens;
	}
}