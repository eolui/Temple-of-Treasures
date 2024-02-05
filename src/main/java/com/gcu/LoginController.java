package com.gcu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.SecurityServiceInterface;
import com.gcu.business.UsersBusinessServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.ProductsModel;
import com.gcu.model.RegisterModel;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	
	@Autowired
	SecurityServiceInterface securityService;
	
	@Autowired
	private UsersBusinessServiceInterface usersService;
	
	@GetMapping("/")
	public String display(Model model)
	{
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@GetMapping("/{id}")
	public RegisterModel getOne(@PathVariable(name="id") long id) 
	{
		return usersService.getById(id);
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// Check for valid login name password
		if(securityService.isAuthenticated(loginModel))
		{
			model.addAttribute("model", loginModel);
			return "index";
		}
		else
		{
			return "login";
		}
	}
}
