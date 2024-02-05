package com.gcu;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

//import com.gcu.business.AnotherOrderBusinessService;
import com.gcu.business.FiveValidLogins;
import com.gcu.business.ProductsBusinessService;
import com.gcu.business.ProductsBusinessServiceInterface;
//import com.gcu.business.OrderBusinessService;
//import com.gcu.business.OrderBusinessServiceInterface;
import com.gcu.business.SecurityServiceInterface;
import com.gcu.business.UsersBusinessService;
import com.gcu.business.UsersBusinessServiceInterface;
import com.gcu.data.ProductsDataAccessInterface;
import com.gcu.data.ProductsDataService;
import com.gcu.data.ProductsDataServiceForRepository;
import com.gcu.data.UsersDataAccessInterface;
import com.gcu.data.UsersDataServiceForRepository;
import com.gcu.model.ProductsModel;
import com.gcu.model.RegisterModel;

@Configuration
public class SpringConfig 
{
	
	@Bean(name="orderBusinessService", initMethod="init", destroyMethod="destroy")
	@RequestScope	
	public ProductsBusinessServiceInterface getOrderBusiness()
	{
		// OrderBusinessService was for adventure travel experiences
		// AnotherOrderBusinessService gives you junk food
		
		return new ProductsBusinessService();
	}
	
	@Bean(name="usersService")
	@RequestScope	
	public UsersBusinessServiceInterface getUserBusiness()
	{
		// OrderBusinessService was for adventure travel experiences
		// AnotherOrderBusinessService gives you junk food
		
		return new UsersBusinessService();
	}
	
	@Autowired
	private DataSource dataSource;
	
	@Bean(name="productsDAO")
	@RequestScope
	public ProductsDataAccessInterface<ProductsModel> getDataService1()
	{
		return new ProductsDataServiceForRepository(dataSource);
	}
	
	@Bean(name="usersDAO")
	@RequestScope
	public UsersDataAccessInterface<RegisterModel> getDataService()
	{
		return new UsersDataServiceForRepository(dataSource);
	}
	
	
	@Bean(name="securityService")
	public SecurityServiceInterface getSecurityService()
	{
		return new FiveValidLogins();
	}
}
