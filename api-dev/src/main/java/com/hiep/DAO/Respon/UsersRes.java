package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Users;

public interface UsersRes extends JpaRepository<Users, Integer> {
	
}
	