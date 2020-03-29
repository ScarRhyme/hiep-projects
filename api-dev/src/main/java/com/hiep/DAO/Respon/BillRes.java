package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Bill;

public abstract class BillRes implements JpaRepository<Bill, Integer> {

}
