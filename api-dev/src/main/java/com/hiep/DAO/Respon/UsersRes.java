package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Users;

public abstract class UsersRes implements JpaRepository<Users, Integer> {
	
}
