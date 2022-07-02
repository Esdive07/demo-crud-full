package com.rah.demo.crud.full.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.rah.demo.crud.full.entity.UserEntity;
import com.rah.demo.crud.full.service.UserService;

public class ControllerTest {
	private UserController userController;
	@Mock
	private UserService userServices;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.userController = new UserController(userServices);
	}

	@Test
	public void createUserTest() {

		UserEntity userEntity = new UserEntity();

		when(this.userServices.createUser(userEntity)).thenReturn(userEntity);

		ResponseEntity<UserEntity> response = this.userController.createUser(userEntity);
		assertNotNull(response);
	}

}
