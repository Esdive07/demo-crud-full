package com.rah.demo.crud.full.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.rah.demo.crud.full.entity.DireccionEntity;
import com.rah.demo.crud.full.entity.UserEntity;
import com.rah.demo.crud.full.service.UserService;

public class ControllerTest {
	private UserController userController;
	@Mock
	private UserService userServices;

	@Test
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.userController = new UserController(userServices);
	}

	@Test
	public void createUserTest() {

		UserEntity userEntity = new UserEntity();
		List<DireccionEntity> direccionEntities = new ArrayList<>();
		DireccionEntity direccion = new DireccionEntity();
		userEntity.setId(1);
		userEntity.setNombre("Esme");
		userEntity.setApellido("Diaz");
		userEntity.setEdad(28);
		userEntity.setDocumento(12345);
		direccion.setId(1);
		direccion.setCalle(69);
		direccion.setCodigoPostal(28019);
		direccion.setLocalidad("Carabanchel");
		direccion.setPuerta("1e");
		direccion.setUserEntity(userEntity);
		direccionEntities.add(direccion);
		userEntity.setDireccionEntities(direccionEntities);

		UserEntity salida = new UserEntity();
		salida.setId(userEntity.getId());
		salida.setNombre(userEntity.getNombre());
		salida.setApellido(userEntity.getApellido());
		salida.setEdad(userEntity.getEdad());
		salida.setDocumento(userEntity.getDocumento());

		salida.setDireccionEntities(userEntity.getDireccionEntities());

		when(this.userServices.createUser(userEntity)).thenReturn(userEntity);
		ResponseEntity<UserEntity> response = this.userController.createUser(userEntity);
		assertNotNull(response);
	}
}
