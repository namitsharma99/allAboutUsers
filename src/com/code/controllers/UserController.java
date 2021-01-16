package com.code.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.code.beans.Message;
import com.code.beans.User;
import com.code.services.KafkaProducer;
import com.code.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private KafkaProducer kafkaProducer;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@Transactional
	public Optional<User> addUser(@RequestBody User user) throws JsonProcessingException {
		Optional<User> addedUser = userService.addUser(user);
		Message message = new Message();

		if (addedUser.isPresent()) {
			message.setUuid(user.getUserId());
			message.setMessage("Added user with ID: " + user.getUserId());
			ObjectMapper objMapper = new ObjectMapper();
			kafkaProducer.produce(objMapper.writeValueAsString(message));
		} else {
			message.setUuid(user.getUserId());
			message.setMessage("Failed to add user with ID: " + user.getUserId());
			ObjectMapper objMapper = new ObjectMapper();
			kafkaProducer.produce(objMapper.writeValueAsString(message));
		}
		return addedUser;
	}

	@RequestMapping("/getUser/{uuid}")
	public Optional<User> getUserById(@PathVariable String uuid) {
		return userService.getUserById(uuid);
	}

	@RequestMapping("/getUsers")
	public List<User> getAllUser() {
		return userService.getAllUsers();
	}

	@RequestMapping("/deleteUser/{uuid}")
	@Transactional
	public void deleteUserById(@PathVariable String uuid) {
		userService.deleteUserById(uuid);
	}

}