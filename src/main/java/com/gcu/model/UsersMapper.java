package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersMapper implements RowMapper<RegisterModel>
{
	public RegisterModel mapRow(ResultSet rs, int i) throws SQLException
	{
		RegisterModel user = new RegisterModel(
				rs.getString("username"),
				rs.getString("password"),
				rs.getString("firstName"),
				rs.getString("lastName"),
				rs.getString("email"),
				rs.getLong("id")
				);
		
		return user;
				
	}
}
