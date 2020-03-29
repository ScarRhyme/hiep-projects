package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.CommandUser;
public interface CommandUserRes extends JpaRepository<CommandUser, Integer> {
	

}
