package com.rah.demo.crud.full.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rah.demo.crud.full.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
