package com.gcu.business;

import java.util.List;

import com.gcu.model.ProductsModel;


public interface ProductsBusinessServiceInterface 
{
	public void test();
	public List<ProductsModel> getProducts();
	public ProductsModel getOne(long id);
	public List<ProductsModel> searchProducts(String searchTerm);
	public long addOne(ProductsModel newOrder);
	public boolean deleteOne(long id);
	public ProductsModel updateOne(long idToUpdate, ProductsModel updateOrder);
	public void init();
	public void destroy();
}
