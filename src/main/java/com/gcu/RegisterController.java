package com.gcu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.business.SecurityServiceInterface;
import com.gcu.business.UsersBusinessServiceInterface;
import com.gcu.model.ProductsModel;
import com.gcu.model.RegisterModel;

@Controller
@RequestMapping("/register")
public class RegisterController
{
	
	@Autowired
	private UsersBusinessServiceInterface usersService;
	
	@Autowired
	SecurityServiceInterface securityService;
	
	@GetMapping("/")
	public String display(Model model)
	{
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}
	
	@PostMapping("/add")
	public String addProduct(RegisterModel newUser, Model model)
	{
		model.addAttribute("title", "Register new User");
		model.addAttribute("newUser", newUser);
		usersService.addOne(newUser);
		return "register";
	}
	
}
