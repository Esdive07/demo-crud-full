package com.rah.demo.crud.full.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rah.demo.crud.full.entity.DireccionEntity;
import com.rah.demo.crud.full.entity.UserEntity;
import com.rah.demo.crud.full.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	/**
	 * 1. Validar que los siguientes campos no sean nulos ni vacios:
	 * 
	 * DOCUMENTO, NOMBRE, APELLIDO,
	 * 
	 * de lo contrario no debe permitir crear ul usuario
	 * 
	 * 2. Si la lista de direcciones esta vacia, llenar una dirección por defecto
	 * 
	 * @param userEntity
	 * @return
	 */
	// create
	public UserEntity createUser(UserEntity userEntity) {

		if (userEntity.getDocumento() != null && userEntity.getDocumento() > 0) {
			if (userEntity.getNombre() != null && !userEntity.getNombre().isBlank()) {
				if (userEntity.getApellido() != null && !userEntity.getApellido().isBlank()) {
					if (userEntity.getDireccionEntities().size() == 0) {

						List<DireccionEntity> direccionEntities = new ArrayList<>();

						DireccionEntity direccion = new DireccionEntity();
						direccion.setCodigoPostal(2893);
						direccion.setCalle(69);
						direccion.setPuerta("1e");
						direccion.setLocalidad("General");
						direccion.setUserEntity(userEntity);

						direccionEntities.add(direccion);

						userEntity.setDireccionEntities(direccionEntities);
					}
					return this.userRepository.save(userEntity);
				}
			}
		}
		return null;
	}

	/**
	 * Validar si el numero de usuarios es mayor a 5 retorne una lista vacia
	 * 
	 * @param userEntity
	 * @return
	 */
	// get All
	public List<UserEntity> getAllUser() {

		List<UserEntity> userEntities = this.userRepository.findAll();

		if (userEntities.size() > 5) {
			return new ArrayList<>();
		}
		return userEntities;
	}

	/**
	 * 1. validar si la edad es mayor a 15 y la lista esta vacia agregar una nueva
	 * dirección.
	 * 
	 * 
	 * @param userEntity
	 * @param id
	 * @return
	 */
	// update
	public UserEntity updateUser(UserEntity userEntity, Integer id) {
		userEntity.setId(id);

		if (userEntity.getEdad() > 15 && userEntity.getDireccionEntities().size() == 0) {

			List<DireccionEntity> direccionEntities = new ArrayList<>();

			DireccionEntity direccion = new DireccionEntity();
			direccion.setCodigoPostal(2345);
			direccion.setCalle(69);
			direccion.setLocalidad("Generalr");
			direccion.setPuerta("1E");
			direccion.setUserEntity(userEntity);

			direccionEntities.add(direccion);
			userEntity.setDireccionEntities(direccionEntities);

			return this.userRepository.save(userEntity);

		} else {

			if (userEntity.getDireccionEntities().size() > 0) {

				userEntity.getDireccionEntities().clear();
			}

			return this.userRepository.save(userEntity);
		}
	}

	// delete
	public void deleteUser(Integer id) {
		this.userRepository.deleteById(id);
	}

	// get by id
	public UserEntity getUserById(Integer id) {
		return this.userRepository.findById(id).get();
	}
}
