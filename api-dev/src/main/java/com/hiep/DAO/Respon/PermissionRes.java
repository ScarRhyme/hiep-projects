package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Permission;

public abstract class PermissionRes implements JpaRepository<Permission , Integer> {
	
}
