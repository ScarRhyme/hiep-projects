package com.report.evaluate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.UttData;
import com.report.evaluate.bo.CriterionEvaluateBO;
import com.report.evaluate.dao.CriterionEvaluateDAO;;
/**
 * @author 
 * @since 09/01/2019
 * @version 1.0
 */
@Service
public class CriterionEvaluateService {

    @Autowired
    private CriterionEvaluateDAO criterionEvaluateDAO;
    @Autowired
    private UttData uttData;
    

    /**
     * findById
     * @param SalaryTableId
     * @return
     */
    public CriterionEvaluateBO findById(Long evaluateId) {
        if (criterionEvaluateDAO.findById(evaluateId).isPresent()) {
            return criterionEvaluateDAO.findById(evaluateId).get();
        } else {
            return null;
        }
    }

    /**
     * findById
     * @param SalaryTableId
     * @return
     */
    public List<CriterionEvaluateBO> findByEvaluateId(Long evaluateId) {
        return criterionEvaluateDAO.findByEvaluateId(evaluateId);
    }

    /**
     * findByAll
     * @return
     */

    public List<CriterionEvaluateBO> findByAll() {
    	return criterionEvaluateDAO.findAll();
    }
    


    /**
     * saveOrUpdate
     * @param entity
     */
    @Transactional
    public void saveOrUpdate(CriterionEvaluateBO entity) {
        criterionEvaluateDAO.save(entity);
        uttData.flushSession();
        uttData.clear();
    }
    

    /**
     * delete
     * @param entity
     */
    public void delete(CriterionEvaluateBO entity) {
        criterionEvaluateDAO.delete(entity);
    }
    
    /**
     * delete
     * @param entity
     */
    public void deleteAll(List<CriterionEvaluateBO> entity) {
        criterionEvaluateDAO.deleteAll(entity);
    }


}
