package com.gcu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("products")
public class ProductEntity 
{
	// Match the properties with the column names of the database
	@Column("name")
	String name;
	
	@Column("showMovies")
	String showMovies;
	
	@Column("rarity")
	String rarity;
	
	@Column("year")
	int year;
	
	@Column("category")
	String category;
	
	@Column("description")
	String description;
	
	@Column("price")
	float price;
	
	@Column("imageURL")
	String imageURL;
	
	@Id
	@Column("id")
	long id;
	
	// Parameter-less constructor for the mapping dependency we will use later
	public ProductEntity()
	{
		
	}

	public ProductEntity(String name, String showMovies, String rarity, int year, String category, String description,
			float price, String imageURL, long id) {
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
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getShowMovies() 
	{
		return showMovies;
	}
	
	public void setShowMovies(String showMovies) 
	{
		this.showMovies = showMovies;
	}
	
	public String getRarity() 
	{
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
