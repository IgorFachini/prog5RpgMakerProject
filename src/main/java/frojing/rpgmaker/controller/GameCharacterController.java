package frojing.rpgmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frojing.rpgmaker.data.GameCharacterDao;
import frojing.rpgmaker.entity.GameCharacter;

@Controller
public class GameCharacterController {

	@Autowired
	private GameCharacterDao dao;

	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("characters", dao.findAll());
		System.out.println("Returning characters:");
		return "characters";
	}

	@RequestMapping("character/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("character", dao.findOne(id));
		return "charactershow";
	}

	@RequestMapping("character/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("character", dao.findOne(id));
		return "characterform";
	}

	@RequestMapping("character/new")
	public String create(Model model) {
		model.addAttribute("character", new GameCharacter());
		return "characterSheets/world_of_darkness";
	}

	@RequestMapping(value = "character", method = RequestMethod.POST)
	public String save(GameCharacter character) {
		dao.save(character);
		return "redirect:/character/" + character.getId();
	}

	@RequestMapping("character/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.delete(id);
		return "redirect:/characters";
	}

}