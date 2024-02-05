package com.gcu.data;

import java.util.List;

import com.gcu.model.ProductsModel;

public interface ProductsDataAccessInterface<T>
{
	public T getById(long id);
	public List<T> getProducts();
	public List<T> searchProducts(String searchTerm);
	public long addOne(T newOrder);
	public boolean deleteOne(long id);
	public T updateOne(long idToUpdate, ProductsModel updateOrder);
}
