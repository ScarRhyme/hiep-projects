package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.ProductLocation;

public abstract class ProductLocationRes implements JpaRepository<ProductLocation, Integer> {
	
}
