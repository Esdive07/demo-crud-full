package com.rah.demo.crud.full.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rah.demo.crud.full.entity.UserEntity;
import com.rah.demo.crud.full.repository.UserRepository;

public class ServiceTests {

	private UserService userService;

	@Mock
	private UserRepository userRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.userService = new UserService(userRepository);
	}

	@Test
	public void createUserTests() {

		UserEntity userEntity = new UserEntity();
		userEntity.setNombre("Esme");
		userEntity.setApellido("Diaz");

		UserEntity salidaUser = new UserEntity();
		salidaUser.setId(1);
		salidaUser.setNombre(userEntity.getNombre());
		salidaUser.setApellido(userEntity.getApellido());

		when(this.userRepository.save(userEntity)).thenReturn(salidaUser);

		UserEntity response = this.userService.createUser(userEntity);
		assertNotNull(response);
		assertEquals(salidaUser.getId(), response.getId());
		assertEquals(salidaUser.getNombre(), response.getNombre());
		assertEquals(salidaUser.getApellido(), response.getApellido());
	}

	@Test
	public void updateUserTests() {

		UserEntity userEntity = new UserEntity();
		Integer id = 1;
		userEntity.setNombre("Esme");
		userEntity.setApellido("Diaz");

		UserEntity salidaUser = new UserEntity();
		salidaUser.setId(id);
		salidaUser.setNombre(userEntity.getNombre());

		when(this.userRepository.save(userEntity)).thenReturn(salidaUser);

		UserEntity response = this.userService.updateUser(userEntity, id);
		assertNotNull(response);
		assertEquals(salidaUser.getNombre(), response.getNombre());
		assertEquals(salidaUser.getApellido(), response.getApellido());
	}

	@Test
	public void getAllUserTest() {

		List<UserEntity> listaEntities = new ArrayList<>();
		UserEntity userEntity = new UserEntity();
		listaEntities.add(userEntity);
				
		when(this.userRepository.findAll()).thenReturn(listaEntities);
		List<UserEntity> response = this.userService.getAllUser();
		assertNotNull(response);

	}

	@Test
	public void updateUserTest() {
		UserEntity userEntity = new UserEntity();
		Integer id = 1;

		when(this.userRepository.save(userEntity)).thenReturn(userEntity);
		UserEntity response = this.userService.updateUser(userEntity, id);
		assertNotNull(response);
	}

}
