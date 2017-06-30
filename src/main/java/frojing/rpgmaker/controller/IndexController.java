package frojing.rpgmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import frojing.rpgmaker.data.PlayerDao;
import frojing.rpgmaker.entity.Player;
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
		Player player = playerDao.findOne(3L);
		
		model.addAttribute("chronicles", dao.findAll());
		model.addAttribute("chroniclesJoin", dao.findByPlayersContains(player));
		model.addAttribute("chroniclesMaster", dao.findByGameMaster(player));
		
		System.out.println("Returning chronicles:");
		return "index";
	}

}
