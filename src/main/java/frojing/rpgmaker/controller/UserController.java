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

	/**
	 * List all users.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("users", userDao.findAll());
		System.out.println("Returning user:");
		return "users";
	}

	/**
	 * View a specific user by its id.
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("user/{id}")
	public String showUser(@PathVariable Long id, Model model) {
		model.addAttribute("user", userDao.findOne(id));
		return "usershow";
	}

	@RequestMapping("user/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("user", userDao.findOne(id));
		return "userform";
	}

	/**
	 * New user.
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("user/new")
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "userform";
	}

	/**
	 * Save user to database.
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public String saveUser(User user) {
		userDao.save(user);
		return "redirect:/user/" + user.getId();
	}

	/**
	 * Delete user by its id.
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping("user/delete/{id}")
	public String delete(@PathVariable Long id) {
		userDao.delete(id);
		return "redirect:/users";
	}

}
