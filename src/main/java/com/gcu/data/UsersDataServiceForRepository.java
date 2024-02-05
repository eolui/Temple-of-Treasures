package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.RegisterModel;
import com.gcu.model.UserEntity;

public class UsersDataServiceForRepository implements UsersDataAccessInterface<RegisterModel> 
{
	@Autowired 
	private UsersRepositoryInterface usersRepository;
	
	private JdbcTemplate jdbcTemplateObject;
	
	public UsersDataServiceForRepository(DataSource dataSource)
	{
		super();
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public RegisterModel getById(long id) 
	{
		UserEntity entity = usersRepository.findById(id).orElse(null);
		
		RegisterModel model = converter(entity);
		return model;				
	}

	@Override
	public List<RegisterModel> getUsers() 
	{
		Iterable<UserEntity> ents = usersRepository.findAll();
		List<RegisterModel> mods = new ArrayList<RegisterModel>();
		
		for(UserEntity ent: ents)
		{
			mods.add(converter(ent));
		}
		for(RegisterModel ent: mods)
		{
			System.out.println(ent);
		}
		
		return mods;
		
	}
	
	private RegisterModel converter(UserEntity ent)
	{
		return(new RegisterModel(
				ent.getUsername(),
				ent.getPassword(),
				ent.getFirstName(),
				ent.getLastName(),
				ent.getEmail(),
				ent.getId()
				
				));
	}
	

	@Override
	public List<RegisterModel> searchUsers(String searchTerm) 
	{
		Iterable<UserEntity> entities = usersRepository.findByNameContainingIgnoreCase(searchTerm);
		List<RegisterModel> users = new ArrayList<RegisterModel>();
		
		for(UserEntity entity: entities)
		{
			users.add(modelMapper.map(entity, RegisterModel.class));
		}
		
		return users;
	}

	@Override
	public long addOne(RegisterModel newOrder) 
	{
		UserEntity entity = new UserEntity(
				newOrder.getUsername(),
				newOrder.getPassword(),
				newOrder.getFirstName(),
				newOrder.getUsername(),
				newOrder.getEmail(),
				newOrder.getId()
				);
				
		UserEntity result = usersRepository.save(entity);
		
		if(result == null)
		{
			return 0;
		}
		else
		{
			return result.getId();
		}
	}
}
