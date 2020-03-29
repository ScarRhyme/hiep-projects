package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Customer;

public abstract class CustomerRes implements JpaRepository<Customer, Integer> {

}
