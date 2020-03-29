package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.BillDetail;

public abstract class BillDetailRes implements JpaRepository<BillDetail, Integer> {
	
}
