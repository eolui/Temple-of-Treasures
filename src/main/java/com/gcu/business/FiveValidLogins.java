package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataService;
import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;

public class FiveValidLogins implements SecurityServiceInterface 
{
	
	@Autowired
	UsersDataService users;

	@Override
	public boolean isAuthenticated(LoginModel loginModel) 
	{
		List<RegisterModel> login = users.getUsers();
		
		boolean success = false;
		for(int i = 0; i < login.size(); i++)
		{
			if(loginModel.getUsername().equals(login.get(i).getUsername()) && loginModel.getPassword().equals(login.get(i).getPassword()))
			{
				success = true;
			}
		}
		
		return success;
	}

}
