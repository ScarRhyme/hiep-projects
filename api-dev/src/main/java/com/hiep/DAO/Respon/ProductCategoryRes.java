package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.ProductCategory;

public abstract class ProductCategoryRes implements JpaRepository<ProductCategory, Integer> {
	
}
