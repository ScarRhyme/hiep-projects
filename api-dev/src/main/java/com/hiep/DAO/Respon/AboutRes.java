package com.hiep.DAO.Respon;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiep.Entities.About;

import java.util.List;

@Transactional
@Repository
public interface AboutRes extends JpaRepository<About, Integer> {
	public List<About> findbyTittle(String tittle);
}
