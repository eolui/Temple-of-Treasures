package com.gcu;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductsBusinessServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.ProductsModel;
import com.gcu.model.SearchOrdersModel;

@Controller
@RequestMapping("/products")
public class ProductsControllerForPages {
	
	//dependency injection.
    ProductsBusinessServiceInterface service;
	
    @Autowired
	public ProductsControllerForPages(ProductsBusinessServiceInterface service) 
    {
		super();
		this.service = service; 
    }

	@GetMapping("/")
	public String showAllOrders(Model model) 
	{
		List<ProductsModel> products = service.getProducts();
				
		// Show products
		model.addAttribute("title", "All Products");
		model.addAttribute("productsTable", products);
				
		return "productsTable";
	}
	
	@GetMapping("/catalog")
	public String showCatalog(Model model) 
	{
		List<ProductsModel> products = service.getProducts();
				
		// Show products
		model.addAttribute("title", "All Products");
		model.addAttribute("productsTable", products);
				
		return "catalog";
	}
	
	@GetMapping("/searchForm") 
	public String displaySearchForm(Model model)
	{
		
		model.addAttribute("title", "Search Products");
		model.addAttribute("searchProducts", new SearchOrdersModel());
		
		return "productsSearch";
	}

	@PostMapping("/searchResults") 
	public String showAllOrders(@Valid SearchOrdersModel searchModel, BindingResult bindingResult, Model model) 
	{ 
		System.out.println("Performing search results for " + searchModel.getSearchTerm());
		// Check for validation errors
        if (bindingResult.hasErrors()) 
        {
        	model.addAttribute("title", "Search for Orders");
        	System.out.println("d");
            return "productsSearch";
        }
		List<ProductsModel> productsTable = service.searchProducts(searchModel.getSearchTerm());  
		
		System.out.println(productsTable.size());
		
	 	model.addAttribute("title", "Search for Orders");
		model.addAttribute("searchOrdersModel", searchModel);
		model.addAttribute("productsTable", productsTable);
		
		return "productsTable.html"; 
	}
		
		@GetMapping("/addNewForm") 
		public String displayAddNewForm(Model model)
		{
			// Display new order form
			model.addAttribute("title", "Add new order");
			model.addAttribute("productsModel", new ProductsModel());
			return "listingProducts";
		} 
		
		@PostMapping("/addNew") 
		// process a request from the AddOrderForm.  Add a new order to the database.  Show all orders.
		public String addOrder(@Valid ProductsModel newOrder, BindingResult bindingResult, Model model) 
		{
			// add the new order
			service.addOne(newOrder);
			// get updated list of all the orders
			List<ProductsModel> products = service.getProducts();
			
			// Show products
			model.addAttribute("title", "All Products");
			model.addAttribute("productsTable", products);
			return "productsTable";
		}
			 
		@GetMapping("/editForm") 
		public String displayEditForm(ProductsModel orderModel, Model model)
		{
			// Display new order form
			model.addAttribute("title", "Edit order");
			model.addAttribute("orderModel", orderModel);
			return "update";
		}
		
		@PostMapping("/doUpdate") 
		// process a request from the AddOrderForm.  Add a new order to the database.  Show all orders.
		public String updateOrder(@Valid ProductsModel order, BindingResult bindingResult, Model model) 
		{
			// add the new order
			service.updateOne(order.getId(), order);
			
			// get updated list of all the orders
			List<ProductsModel> orders = service.getProducts(); 
			
			// display all orders
			model.addAttribute("orders", orders); 
			model.addAttribute("searchModel", new SearchOrdersModel()); 
			return "update";
		}
		@GetMapping("/delete")
		public String deleteProduct(ProductsModel orderModel, Model model) {
			List<ProductsModel> products = service.getProducts();
			model.addAttribute("title", "Delete a Product");
			model.addAttribute("productsTable", products);
			return "deleteProducts";
		}
		@PostMapping("/doDelete")
		public String doDeleteProduct(@Valid ProductsModel order, BindingResult bindingResult, Model model) {
			service.deleteOne(order.getId());
			List<ProductsModel> products = service.getProducts();
			model.addAttribute("title", "Delete a Product");
			model.addAttribute("productsTable", products);
			return "deleteProducts";
		}

	}
