package frojing.rpgmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import frojing.rpgmaker.data.PlayerDao;
import frojing.rpgmaker.data.ChronicleDao;
import org.springframework.ui.Model;

@Controller
public class IndexController {

	@Autowired
	private ChronicleDao dao;
	@Autowired
	private PlayerDao playerDao;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("chronicles", dao.findAll());
		model.addAttribute("chroniclesJoin", dao.findAll());
		model.addAttribute("chroniclesMaster", dao.findAll());
		System.out.println("Returning chronicles:");
		return "index";
	}

}
