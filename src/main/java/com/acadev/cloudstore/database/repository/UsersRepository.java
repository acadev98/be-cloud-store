package com.acadev.cloudstore.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.acadev.cloudstore.database.entity.Users;

public interface UsersRepository extends PagingAndSortingRepository<Users, Integer>, JpaRepository<Users, Integer> {

	Optional<Users> findByMail(String mail);
	
}