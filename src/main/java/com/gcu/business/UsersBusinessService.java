package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataAccessInterface;
import com.gcu.model.RegisterModel;

public class UsersBusinessService implements UsersBusinessServiceInterface
{
	@Autowired
	UsersDataAccessInterface<RegisterModel> usersDAO;

	@Override
	public RegisterModel getById(long id) 
	{
		return usersDAO.getById(id);
	}

	@Override
	public List<RegisterModel> getUsers() 
	{
		return usersDAO.getUsers();
	}

	@Override
	public List<RegisterModel> searchUsers(String searchTerm)
	{
		return usersDAO.searchUsers(searchTerm);
	}

	@Override
	public long addOne(RegisterModel newOrder)
	{
		return usersDAO.addOne(newOrder);
	}
	
	
}
