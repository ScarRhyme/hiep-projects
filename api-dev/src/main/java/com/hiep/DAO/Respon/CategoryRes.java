package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.Category;
public interface CategoryRes extends JpaRepository< Category, Integer> {


}
