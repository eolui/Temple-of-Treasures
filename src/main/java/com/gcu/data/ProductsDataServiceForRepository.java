package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.model.ProductEntity;
import com.gcu.model.ProductsModel;

public class ProductsDataServiceForRepository implements ProductsDataAccessInterface<ProductsModel> 
{
	@Autowired
	private ProductsRepositoryInterface ordersRepository;
	
	private JdbcTemplate jdbcTemplateObject;
	
	public ProductsDataServiceForRepository(DataSource dataSource)
	{
		super();
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	ModelMapper modelMapper = new ModelMapper();

	// Delete this later - Same thing as searchProducts()
	@Override
	public ProductsModel getById(long id) 
	{
		ProductEntity entity = ordersRepository.findById(id).orElse(null);
		
		ProductsModel model = modelMapper.map(entity, ProductsModel.class);
		
		return model;
	}

	@Override
	public List<ProductsModel> getProducts() 
	{
		Iterable<ProductEntity> ents = ordersRepository.findAll();
		List<ProductsModel> mods = new ArrayList<ProductsModel>();
		
		for(ProductEntity ent: ents)
		{
			mods.add(modelMapper.map(ent,  ProductsModel.class));
		}
		
		return mods;
	}

	@Override
	public List<ProductsModel> searchProducts(String searchTerm) 
	{
		Iterable<ProductEntity> entities = ordersRepository.findByNameContainingIgnoreCase(searchTerm);
		List<ProductsModel> products = new ArrayList<ProductsModel>();
		
		for(ProductEntity entity: entities)
		{
			products.add(modelMapper.map(entity,  ProductsModel.class));
		}
		
		return products;
	}

	@Override
	public long addOne(ProductsModel newOrder) 
	{
		ProductEntity entity = modelMapper.map(newOrder, ProductEntity.class);
		ProductEntity result = ordersRepository.save(entity);
		if (result == null)
		{
			return 0;
		}
		else
		{
			return result.getId();
		}
	}

	@Override
	public boolean deleteOne(long id) 
	{
		ordersRepository.deleteById(id);
		return true;
	}

	@Override
	public ProductsModel updateOne(long idToUpdate, ProductsModel updateOrder) 
	{
		ProductEntity entity = modelMapper.map(updateOrder, ProductEntity.class);
		ProductEntity result = ordersRepository.save(entity);
		ProductsModel order = modelMapper.map(result, ProductsModel.class);
		
		return order;
		
	}
	  
	
}
