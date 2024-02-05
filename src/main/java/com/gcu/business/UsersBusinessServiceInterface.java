package com.gcu.business;

import java.util.List;

import com.gcu.model.RegisterModel;

public interface UsersBusinessServiceInterface 
{
	public RegisterModel getById(long id);
	public List<RegisterModel> getUsers();
	public List<RegisterModel> searchUsers(String searchTerm);
	public long addOne(RegisterModel newOrder);
}
