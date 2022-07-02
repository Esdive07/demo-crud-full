package com.rah.demo.crud.full.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rah.demo.crud.full.entity.UserEntity;
import com.rah.demo.crud.full.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userServices;

	public UserController(UserService userServices) {
		super();
		this.userServices = userServices;
	}

	@PostMapping
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userServices.createUser(userEntity));

	}

	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUser() {
		return ResponseEntity.ok(this.userServices.getAllUser());
	}

	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity, @PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.userServices.updateUser(userEntity, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		this.userServices.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

	}

	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
		return ResponseEntity.ok(this.userServices.getUserById(id));
	}

}
