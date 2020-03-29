package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Bill;
public interface BillRes extends JpaRepository<Bill, Integer> {
	

}
