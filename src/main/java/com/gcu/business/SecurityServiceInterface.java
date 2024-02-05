package com.gcu.business;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;

public interface SecurityServiceInterface 
{
	public boolean isAuthenticated(LoginModel loginModel);
}
