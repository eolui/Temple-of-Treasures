package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.RegisterModel;
import com.gcu.model.UsersMapper;

@Repository
public class UsersDataService implements UsersDataAccessInterface<RegisterModel>
{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	
	
	public UsersDataService(DataSource dataSource, JdbcTemplate jdbcTemplate) 
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public RegisterModel getById(long id) 
	{
		return jdbcTemplate.queryForObject("select * from login where id = ?", new UsersMapper(), new Object[]
				{id});
	}
	@Override
	public List<RegisterModel> getUsers() 
	{
		return jdbcTemplate.query("select * from login", new UsersMapper());
	}
	@Override
	public List<RegisterModel> searchUsers(String searchTerm) 
	{
		return jdbcTemplate.query("select * from login where username like ?", new UsersMapper(), new Object[] {"%" + searchTerm + "%"});
	}
	@Override
	public long addOne(RegisterModel newOrder) 
	{
		return jdbcTemplate.update("insert into login (username, password, firstName, lastName, email) values (?,?,?,?,?)",
				newOrder.getUsername(),
				newOrder.getPassword(),
				newOrder.getFirstName(),
				newOrder.getLastName(),
				newOrder.getEmail()
				);
	}
}
