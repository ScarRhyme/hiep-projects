package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.CommandUser;

public abstract class CommandUserRes implements JpaRepository<CommandUser, Integer> {

}
