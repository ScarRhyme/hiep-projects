package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Location;

public interface LocationRes extends JpaRepository<Location, Integer> {

}
