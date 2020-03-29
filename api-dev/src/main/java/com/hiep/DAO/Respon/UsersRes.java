package com.hiep.DAO.Respon;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hiep.Entities.About;

public abstract class UsersRes implements JpaRepository<About, Integer> {
	
}
