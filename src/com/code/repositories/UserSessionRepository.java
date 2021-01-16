package com.code.repositories;

import org.springframework.data.repository.CrudRepository;

import com.code.beans.UserSession;

public interface UserSessionRepository extends CrudRepository<UserSession, String> {


}
