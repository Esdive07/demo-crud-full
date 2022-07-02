package com.rah.demo.crud.full.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rah.demo.crud.full.entity.DireccionEntity;
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
		userEntity.setDocumento(1234);

		List<DireccionEntity> direccionEntities = new ArrayList<>();
		userEntity.setDireccionEntities(direccionEntities);

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
	public void updateUserIfTrueTests() {

		UserEntity userEntity = new UserEntity();
		Integer id = 1;
		userEntity.setNombre("Esme");
		userEntity.setApellido("Diaz");
		userEntity.setEdad(20);

		List<DireccionEntity> direccionEntities = new ArrayList<>();

		userEntity.setDireccionEntities(direccionEntities);

		UserEntity salidaUser = new UserEntity();
		salidaUser.setId(id);
		salidaUser.setNombre(userEntity.getNombre());
		salidaUser.setEdad(userEntity.getEdad());

		when(this.userRepository.save(userEntity)).thenReturn(salidaUser);

		UserEntity response = this.userService.updateUser(userEntity, id);
		assertNotNull(response);
		assertEquals(salidaUser.getNombre(), response.getNombre());
		assertEquals(salidaUser.getApellido(), response.getApellido());
	}

	@Test
	public void updateUserIffalseTests() {

		UserEntity userEntity = new UserEntity();
		Integer id = 1;
		userEntity.setNombre("Esme");
		userEntity.setApellido("Diaz");
		userEntity.setEdad(12);

		List<DireccionEntity> direccionEntities = new ArrayList<>();
		DireccionEntity direccionEntity = new DireccionEntity();
		direccionEntities.add(direccionEntity);

		userEntity.setDireccionEntities(direccionEntities);

		UserEntity salidaUser = new UserEntity();
		salidaUser.setId(id);
		salidaUser.setNombre(userEntity.getNombre());
		salidaUser.setEdad(userEntity.getEdad());

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
		listaEntities.add(userEntity);
		listaEntities.add(userEntity);
		listaEntities.add(userEntity);
		listaEntities.add(userEntity);
		listaEntities.add(userEntity);

		when(this.userRepository.findAll()).thenReturn(listaEntities);
		List<UserEntity> response = this.userService.getAllUser();
		assertNotNull(response);

	}

	@Test
	public void deleteUserTest() {
		Integer id = 1;
		this.userService.deleteUser(id);
	}

	@Test
	public void getUserByIdTest() {
		Integer id = 1;
		UserEntity userEntity = new UserEntity();
		Optional<UserEntity> userEntityOpt = Optional.of(userEntity);

		when(this.userRepository.findById(id)).thenReturn(userEntityOpt);
		UserEntity response = this.userService.getUserById(id);
		assertNotNull(response);
	}

}
