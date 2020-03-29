package com.hiep.DAO.Respon;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiep.Entities.ProductCategory;
public interface  ProductCategoryRes extends JpaRepository<ProductCategory, Integer> {
	
}
	