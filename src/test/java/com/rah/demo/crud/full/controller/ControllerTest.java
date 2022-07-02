package com.rah.demo.crud.full.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

	@Test
	public void getAllUserTest() {
		List<UserEntity> listaUserEntities = new ArrayList<>();
		UserEntity userEntity = new UserEntity();
		listaUserEntities.add(userEntity);

		when(this.userServices.getAllUser()).thenReturn(listaUserEntities);
		ResponseEntity<List<UserEntity>> response = this.userController.getAllUser();
		assertNotNull(response);
	}

	@Test
	public void updateUserTest() {
		UserEntity userEntity = new UserEntity();
		Integer id = 1;

		when(this.userServices.updateUser(userEntity, id)).thenReturn(userEntity);
		ResponseEntity<UserEntity> response = this.userController.updateUser(userEntity, id);
		assertNotNull(response);
	}

	@Test
	public void deleteUserTest() {
		Integer id = 1;
		this.userController.deleteUser(id);
	}

	@Test
	public void getUserByIdTest() {
		Integer id = 1;
		UserEntity userEntity = new UserEntity();

		when(this.userServices.getUserById(id)).thenReturn(userEntity);
		ResponseEntity<UserEntity> response = this.userController.getUserById(id);
		assertNotNull(response);
	}

}
