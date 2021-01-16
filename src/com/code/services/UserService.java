package com.code.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.beans.User;
import com.code.beans.UserSession;
import com.code.repositories.UserRepository;
import com.code.repositories.UserSessionRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserSessionRepository userSessionRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public Optional<User> addUser(User user) {
		String userId =UUID.randomUUID().toString();
		user.setUserId(userId);
		userRepository.save(user);
		
		UserSession userSession = new UserSession();
		userSession.setSessionId(UUID.randomUUID().toString());
		userSession.setSessionStart(new java.sql.Timestamp(new Date().getTime()));
		userSession.setSessionEnd(null);
		userSession.setSessionTime(null);
		userSession.setUserId(user.getUserId());
		
		userSessionRepository.save(userSession);
		
		Optional<User> fetchedSavedUser = userRepository.findByUserId(userId);
		// System.out.println("fetchedSavedUser >> " + fetchedSavedUser);
		return fetchedSavedUser;
	}

	public Optional<User> getUserById(String uuid) {
		Optional<User> fetchedSavedUser = userRepository.findByUserId(uuid);
		// System.out.println("fetchedSavedUser >> " + fetchedSavedUser);
		return fetchedSavedUser;
	}

	public void deleteUserById(String uuid) {
		userRepository.deleteByUserId(uuid);
	}

}
