package com.gcu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("login")
public class UserEntity 
{
	@Column("username")
	String name;
	
	@Column("password")
	String password;
	
	@Column("firstName")
	String firstName;
	
	@Column("lastName")
	String lastName;
	
	@Column("email")
	String email;
	
	@Id
	@Column("id")
	Long id;

	public UserEntity() 
	{
		
	}

	public UserEntity(String name, String password, String firstName, String lastName, String email, Long id) 
	{
		super();
		this.name = name;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
	}

	public String getUsername() {
		return name;
	}

	public void setUsername(String username) {
		this.name = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPwd(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", id=" + id + "]";
	}
	
	
	
	
	
}
