package com.rah.demo.crud.full.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rah.demo.crud.full.entity.UserEntity;
import com.rah.demo.crud.full.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	// create
	public UserEntity createUser(UserEntity userEntity) {
		return this.userRepository.save(userEntity);
	}

	// get All
	public List<UserEntity> getAllUser(UserEntity userEntity) {
		return this.userRepository.findAll();
	}

	// update
	public UserEntity updateUser(UserEntity userEntity, Integer id) {
		userEntity.setId(id);
		return this.userRepository.save(userEntity);
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
