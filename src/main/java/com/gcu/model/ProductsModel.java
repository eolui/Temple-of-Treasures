package com.gcu.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductsModel 
{
	@NotNull(message = "Name is a required field")
	@Size(min = 1, max = 32, message = "Name must be between 1 and 32 characters")
	private String name;
	
	@NotNull(message = "Tv Show/Movie is a required field")
	@Size(min = 1, max = 32, message = "Tv Show/Movie must be between 1 and 32 characters")
	private String showMovies;
	
	@NotNull(message = "Rarity is a required field")
	@Size(min = 1, max = 32, message = "Rarity must be between 1 and 32 characters")
	private String rarity;
	
	@NotNull(message = "Year is a required field")
	@Size(min = 1, max = 32, message = "Year must be in yyyy format")
	private int year;
	
	@NotNull(message = "Category is a required field")
	@Size(min = 1, max = 32, message = "Category must be between 1 and 32 characters")
	private String category;
	
	@NotNull(message = "Description is a required field")
	@Size(min = 1, max = 32, message = "Description must be between 1 and 32 characters")
	private String description;
	
	@NotNull(message = "Price is a required field")
	@Size(min = 1, max = 32, message = "Price must be in 00.0 format")
	private float price;
	
	@NotNull(message = "Image is a required field")
	@Size(min = 1, max = 32, message = "Provide Image URL")
	private String imageURL;
	
	private long id;
	
	public ProductsModel(String name, String showMovies, String rarity, int year, String category, String description,
			float price, String imageURL, long id) 
	{
		super();
		this.name = name;
		this.showMovies = showMovies;
		this.rarity = rarity;
		this.year = year;
		this.category = category;
		this.description = description;
		this.price = price;
		this.imageURL = imageURL;
		this.id = id;
	}
	
	
	
	public ProductsModel() 
	{
		super();
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShowMovies() {
		return showMovies;
	}
	public void setShowMovies(String showMovies) {
		this.showMovies = showMovies;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductsModel [name=" + name + ", showMovies=" + showMovies + ", rarity=" + rarity + ", year=" + year
				+ ", category=" + category + ", description=" + description + ", price=" + price + ", imageURL="
				+ imageURL + ", id=" + id + "]";
	}
	
	
	
	
	
	
	
}
