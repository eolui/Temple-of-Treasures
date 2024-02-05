package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductsDataAccessInterface;
import com.gcu.model.ProductsModel;

public class ProductsBusinessService implements ProductsBusinessServiceInterface 
{
	@Autowired
	ProductsDataAccessInterface<ProductsModel> productsDAO;

	@Override
	public void test()
	{
		System.out.println("The test method of the ANOTHER OrderBusinessService appears to be working if you can see this text.");
	}

	@Override
	public List<ProductsModel> getProducts() 
	{
		return productsDAO.getProducts();
	}

	@Override
	public List<ProductsModel> searchProducts(String searchTerm) 
	{
		return productsDAO.searchProducts(searchTerm);
	}

	@Override
	public long addOne(ProductsModel newOrder) 
	{
		return productsDAO.addOne(newOrder);
	}

	@Override
	public boolean deleteOne(long id)
	{
		return productsDAO.deleteOne(id);
	}

	@Override
	public ProductsModel updateOne(long idToUpdate, ProductsModel updateOrder) 
	{
		return productsDAO.updateOne(idToUpdate, updateOrder);
	}

	@Override
	public void init() 
	{
		System.out.println("Init method of ANOTHER ProductsBusinessService was just called.");
		
	}

	@Override
	public void destroy() 
	{
		System.out.println("Destroy method of ProductsBusinessService was just called.");	
		
	}

	@Override
	public ProductsModel getOne(long id) {
		return productsDAO.getById(id);
	}

}
