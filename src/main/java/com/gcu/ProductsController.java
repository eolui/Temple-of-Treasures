   package com.gcu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.model.ProductsModel;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController 
{
	
	@Autowired
	private ProductsBusinessServiceInterface productsService;
	
	@GetMapping("/")
	public String showAllProducts(Model model)
	{
		// Get Products
		List<ProductsModel> products = productsService.getProducts();
		
		// Show products
		model.addAttribute("title", "All Products");
		model.addAttribute("productsTable", products);
		
		return "productsTable";
		

	}
	@GetMapping("/{id}")
	public ProductsModel getOne(@PathVariable(name="id") long id) 
	{
		return productsService.getOne(id);

	}
	
	@GetMapping("/search/{searchTerm}")
	public List<ProductsModel> searchProducts(@PathVariable(name="searchTerm") String searchTerm)
	{
		return productsService.searchProducts(searchTerm);
	}
	
	@PostMapping("/")
	public ProductsModel addProduct(@RequestBody ProductsModel addOrder)
	{
		productsService.addOne(addOrder);
		return addOrder;
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteProduct(@PathVariable(name="id") long id)
	{
		return productsService.deleteOne(id);
	}
	
	@PutMapping("/")
	public ProductsModel updateProduct(@RequestBody ProductsModel updateOrder)
	{
		return productsService.updateOne(updateOrder.getId(), updateOrder);
	}
	
	
}
