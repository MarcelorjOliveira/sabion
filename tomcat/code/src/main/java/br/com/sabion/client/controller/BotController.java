package br.com.sabion.client.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sabion.client.model.Bot;
import br.com.sabion.client.repository.BotRepository;

@RestController
public class BotController {

	@Autowired
	private BotRepository botRepository;

	@RequestMapping(value = "/botTeste")
	public Bot botTeste() {
		Bot bot = new Bot("nome1");
		botRepository.save(bot);
		return bot;
	}

	@PostMapping(value = "/bot")
	public Bot adicionaOuAtualizaBot(@RequestBody Bot bot) {
		return botRepository.save(bot);
	}

	@RequestMapping(value = "/bot/{id}")
	public Optional<Bot> encontraPeloId(@PathVariable Long id) {
		return botRepository.findById(id);
	}

	@RequestMapping(value = "/bot/{id}/deleta")
	public String deleta(@PathVariable Long id) {
		Optional<Bot> bot = botRepository.findById(id);
		if (bot != null) {
			botRepository.deleteById(id);
			return "Bot deletado com sucesso";
		}
		return "Não foi possível deletar porque o bot não existe";
	}

	@RequestMapping(value = "/listarBots")
	public Iterable<Bot> listarBots() {
		Iterable<Bot> bots = new ArrayList<Bot>();
		bots = botRepository.findAll();
		return bots;
	}
}