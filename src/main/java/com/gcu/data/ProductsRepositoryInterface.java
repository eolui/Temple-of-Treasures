package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.model.ProductEntity;


public interface ProductsRepositoryInterface extends CrudRepository<ProductEntity, Long>
{
	List<ProductEntity> findByNameContainingIgnoreCase(String searchTerm);
}
