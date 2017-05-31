package frojing.rpgmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import frojing.rpgmaker.data.UserDao;
import frojing.rpgmaker.entity.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userDao.findAll());
        return "users";
	}
	
    @RequestMapping("user/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        model.addAttribute("user", userDao.findOne(id));
        return "usershow";
    }

    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", userDao.findOne(id));
        return "userform";
    }

    @RequestMapping("user/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "userform";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveProduct(User user) {
        userDao.save(user);
        return "redirect:/user/" + user.getId();
    }

    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Long id) {
    	userDao.delete(id);
        return "redirect:/users";
    }

}
