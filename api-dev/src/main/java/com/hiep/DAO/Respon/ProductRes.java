package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Product;

public abstract class ProductRes implements JpaRepository<Product, Integer> {

}
