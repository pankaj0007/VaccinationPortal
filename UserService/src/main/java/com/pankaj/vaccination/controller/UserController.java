package com.pankaj.vaccination.controller;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.vaccination.entity.User;
import com.pankaj.vaccination.repositories.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepo userRepos;

	@RequestMapping("/get")
	public ResponseEntity<String> getUsers() {
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<User>> getUsersList(@PathVariable Integer id) {
		List<User> userList = userRepos.findByVaccinationCenterId(id);
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<User> createUSer(@RequestBody User newUser) {
		User user = userRepos.save(newUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
