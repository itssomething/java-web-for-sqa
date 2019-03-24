package net.guides.springboot2.springboot2webappthymeleaf.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.guides.springboot2.springboot2webappthymeleaf.domain.User;
import net.guides.springboot2.springboot2webappthymeleaf.repositories.UserRepository;

@Controller
public class HomeController {
	@Autowired
	UserRepository userRepo;

	@RequestMapping("/users")
	public String home(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "users/index";
	}

	@GetMapping("/users/new")
	public String showSignUpForm(User user) {
		return "users/new";
	}

	@PostMapping("/users/new")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "users/new";
		}

		userRepo.save(user);
		model.addAttribute("users", userRepo.findAll());
		return "users/index";
	}
	
	@GetMapping("/users/{id}/edit")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    User user = userRepo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
	    model.addAttribute("user", user);
	    return "users/edit";
	}
	
	@PostMapping("/users/{id}/edit")
	public String updateUser(@PathVariable("id") int id, @Valid User user, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        user.setId(id);
	        return "users/edit";
	    }
	         
	    userRepo.save(user);
	    model.addAttribute("users", userRepo.findAll());
	    return "users/index";
	}
	     
	@GetMapping("/users/{id}/delete")
	public String deleteUser(@PathVariable("id") int id, Model model) {
	    User user = userRepo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    userRepo.delete(user);
	    model.addAttribute("users", userRepo.findAll());
	    return "users/index";
	}
}
