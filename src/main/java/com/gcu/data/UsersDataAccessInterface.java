package com.gcu.data;

import java.util.List;

import com.gcu.model.RegisterModel;

public interface UsersDataAccessInterface<T> 
{
	public T getById(long id);
	public List<T> getUsers();
	public List<T> searchUsers(String searchTerm);
	public long addOne(T newOrder);
}
