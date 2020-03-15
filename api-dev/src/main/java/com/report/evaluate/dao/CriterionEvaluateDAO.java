package com.report.evaluate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.data.common.UttData;
import com.report.evaluate.bo.CriterionEvaluateBO;

/**
 * @author TanPTN
 * @since 09/01/2019
 * @version 1.0
 */
@Transactional
@Repository
public interface CriterionEvaluateDAO extends CrudRepository<CriterionEvaluateBO, Long> {

    /**
     * List all CriterionEvaluate
     */
    public List<CriterionEvaluateBO> findAll();
    
    /**
     * List all CriterionEvaluate By Id
     */
    public List<CriterionEvaluateBO> findByEvaluateId(Long evaluateId);
    

}
