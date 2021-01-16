package com.code.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.code.beans.User;

public interface UserRepository extends CrudRepository<User, String> {

	Optional<User> findByUserId(String userId);
	void deleteByUserId(String uuid);

}
