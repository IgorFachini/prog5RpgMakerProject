package frojing.rpgmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frojing.rpgmaker.data.PlayerDao;
import frojing.rpgmaker.entity.GameCharacter;
import frojing.rpgmaker.entity.Player;

@Controller
public class PlayerController {

	@Autowired
	private PlayerDao dao;

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("players", dao.findAll());
		System.out.println("Returning players:");
		return "test/players";
	}

	@RequestMapping("player/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("player", dao.findOne(id));
		return "test/playershow";
	}

	@RequestMapping("player/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("player", dao.findOne(id));
		return "test/playerform";
	}

	@RequestMapping("player/new")
	public String create(Model model) {
		model.addAttribute("player", new Player());
		return "test/playerform";
	}

	@RequestMapping(value = "player", method = RequestMethod.POST)
	public String save(Player player) {
		dao.save(player);
		return "redirect:/player/" + player.getId();
	}

	@RequestMapping("player/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.delete(id);
		return "redirect:/players";
	}

}
