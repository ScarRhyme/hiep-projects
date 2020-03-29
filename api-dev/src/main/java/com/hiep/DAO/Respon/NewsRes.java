package com.hiep.DAO.Respon;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiep.Entities.News;

public abstract class NewsRes implements JpaRepository<News, Integer> {

}
