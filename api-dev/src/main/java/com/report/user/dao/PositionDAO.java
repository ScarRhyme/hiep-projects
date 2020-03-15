package com.report.user.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.report.user.entity.PositionBO;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0	
 */
@Transactional
@Repository
public interface PositionDAO extends CrudRepository<PositionBO, Long> {

    public PositionBO findByPositionId(Long positionId);

}
