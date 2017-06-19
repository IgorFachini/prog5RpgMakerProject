package frojing.rpgmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frojing.rpgmaker.data.ChronicleDao;
import frojing.rpgmaker.entity.Character;
import frojing.rpgmaker.entity.Chronicle;

@Controller
public class ChronicleController {

	@Autowired
	private ChronicleDao dao;

	@RequestMapping(value = "/chronicles", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("chronicles", dao.findAll());
		System.out.println("Returning chronicles:");
		return "chronicles";
	}

	@RequestMapping("chronicle/{id}")
	public String show(@PathVariable Long id, Model model) {
		model.addAttribute("chronicle", dao.findOne(id));
		return "chronicleshow";
	}

	@RequestMapping("chronicle/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("chronicle", dao.findOne(id));
		return "chronicleform";
	}

	@RequestMapping("chronicle/new")
	public String create(Model model) {
		model.addAttribute("chronicle", new Character());
		return "chronicleform";
	}

	@RequestMapping(value = "chronicle", method = RequestMethod.POST)
	public String save(Chronicle chronicle) {
		dao.save(chronicle);
		return "redirect:/chronicle/" + chronicle.getId();
	}

	@RequestMapping("chronicle/delete/{id}")
	public String delete(@PathVariable Long id) {
		dao.delete(id);
		return "redirect:/chronicles";
	}

}