package com.rah.demo.crud.full.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EntityTests {

	private UserEntity userEntity;
	private DireccionEntity direccionEntity;

	@BeforeEach
	public void init() {
		this.userEntity = new UserEntity();
		this.direccionEntity = new DireccionEntity();
	}

	@Test
	public void UserEntityTests() {

		Integer id = 1;
		Integer documento = 234;
		String nombre = "Robin";
		String apellido = "Arellano";
		Integer edad = 32;

		this.userEntity.setId(id);
		this.userEntity.setDocumento(documento);
		this.userEntity.setNombre(nombre);
		this.userEntity.setApellido(apellido);
		this.userEntity.setEdad(edad);

		List<DireccionEntity> direccionEntities = new ArrayList<>();
		this.userEntity.setDireccionEntities(direccionEntities);

		assertEquals(id, this.userEntity.getId());
		assertEquals(documento, this.userEntity.getDocumento());
		assertEquals(nombre, this.userEntity.getNombre());
		assertEquals(apellido, this.userEntity.getApellido());
		assertEquals(edad, this.userEntity.getEdad());
		assertNotNull(this.userEntity.getDireccionEntities());
	}

	@Test
	public void DireccionEntity() {

		Integer id = 1;
		String localidad = "General Ricardos";
		Integer calle = 69;
		String puerta = "1E";
		Integer codigoPostal = 5654;

		this.direccionEntity.setId(id);
		this.direccionEntity.setLocalidad(localidad);
		this.direccionEntity.setCalle(calle);
		this.direccionEntity.setPuerta(puerta);
		this.direccionEntity.setCodigoPostal(codigoPostal);
		this.direccionEntity.setUserEntity(userEntity);

		assertEquals(id, this.direccionEntity.getId());
		assertEquals(localidad, this.direccionEntity.getLocalidad());
		assertEquals(calle, this.direccionEntity.getCalle());
		assertEquals(puerta, this.direccionEntity.getPuerta());
		assertEquals(codigoPostal, this.direccionEntity.getCodigoPostal());
		assertNotNull(this.direccionEntity.getUserEntity());

	}
}
