package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.NewCategory;

public abstract class NewCategoryRes implements JpaRepository< NewCategory, Integer> {
}
