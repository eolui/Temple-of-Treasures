package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.ProductsMapper;
import com.gcu.model.ProductsModel;

@Repository
public class ProductsDataService implements ProductsDataAccessInterface<ProductsModel>
{
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public ProductsDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

	public ProductsDataService() 
	{
		
	}



	@Override
	public ProductsModel getById(long id) 
	{
		return jdbcTemplate.queryForObject("select * from products where id = ?", new ProductsMapper(), new Object[]
				{id});
	}

	@Override
	public List<ProductsModel> getProducts() 
	{
		List<ProductsModel> results = jdbcTemplate.query("select * from products", new ProductsMapper());
		return results;
	}

	@Override
	public List<ProductsModel> searchProducts(String searchTerm) 
	{
		return jdbcTemplate.query("select * from treasures where name like ?", new ProductsMapper(), new Object[] {"%" + searchTerm + "%"});
	}

	@Override
	public long addOne(ProductsModel newOrder) 
	{
		return jdbcTemplate.update("insert into products (name, showMovies, rarity, year, category, description, price, imageURL) values (?,?,?,?,?,?,?,?)",
				newOrder.getName(),
				newOrder.getShowMovies(),
				newOrder.getRarity(),
				newOrder.getYear(),
				newOrder.getCategory(),
				newOrder.getDescription(),
				newOrder.getPrice(),
				newOrder.getImageURL()
				);
	}

	@Override
	public boolean deleteOne(long id) 
	{
		int updateResult = jdbcTemplate.update("delete from treasures where id = ?",new Object[] {id});
		return (updateResult > 0);
	}

	@Override
	public ProductsModel updateOne(long idToUpdate, ProductsModel updateOrder) 
	{
		int result = jdbcTemplate.update("update treasures set name = ?, showMovies = ?, rarity = ?, year = ?, category = ?, description = ?, price = ?, imageURL = ? where id = ?",
				updateOrder.getName(),
				updateOrder.getShowMovies(),
				updateOrder.getRarity(),
				updateOrder.getYear(),
				updateOrder.getCategory(),
				updateOrder.getDescription(),
				updateOrder.getPrice(),
				updateOrder.getImageURL()
				);
		if (result > 0)
		{
			return updateOrder;
		}
		else
		{
			return null;
		}
	}
}