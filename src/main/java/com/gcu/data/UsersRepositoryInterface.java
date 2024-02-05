package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.model.UserEntity;

public interface UsersRepositoryInterface extends CrudRepository<UserEntity, Long>{
	List<UserEntity> findByNameContainingIgnoreCase(String searchTerm);

}
