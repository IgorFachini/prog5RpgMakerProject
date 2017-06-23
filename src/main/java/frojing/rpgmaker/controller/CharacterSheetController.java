package frojing.rpgmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frojing.rpgmaker.data.CharacterSheetDao;
import frojing.rpgmaker.entity.GameCharacter;
import frojing.rpgmaker.entity.CharacterSheet;

@Controller
public class CharacterSheetController {

	@Autowired
	private CharacterSheetDao dao;

	@RequestMapping(value = "/charactersheets", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("charactersheets", dao.findAll());
		System.out.println("Returning character sheets:");
		return "charactersheets";
	}

	@RequestMapping("charactersheet/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("charactersheet", dao.findOne(id));
		return "charactersheetshow";
	}

	@RequestMapping("charactersheet/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("charactersheet", dao.findOne(id));
		return "charactersheetform";
	}

	@RequestMapping("charactersheet/new")
	public String create(Model model) {
		model.addAttribute("charactersheet", new GameCharacter());
		return "charactersheetform";
	}

	@RequestMapping(value = "charactersheet", method = RequestMethod.POST)
	public String save(CharacterSheet characterSheet) {
		dao.save(characterSheet);
		return "redirect:/charactersheet/" + characterSheet.getId();
	}

	@RequestMapping("charactersheet/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.delete(id);
		return "redirect:/charactersheets";
	}

}