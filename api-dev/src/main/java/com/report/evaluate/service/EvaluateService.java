package com.report.evaluate.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.viettel.bo.income.domain.SalaryTableDomain;
import com.data.common.CommonUtil;
import com.data.common.TreeNodeBean;
import com.data.common.TreeNodeEvaluateBean;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.report.criterion.bean.CriterionBean;
import com.report.criterion.bo.CriterionBO;
import com.report.criterion.dao.CriterionDAO;
import com.report.criterion.form.CriterionForm;
import com.report.evaluate.bo.EvaluateBO;
import com.report.evaluate.dao.EvaluateDAO;
import com.report.evaluate.form.EvaluateForm;;
/**
 * @author 
 * @since 09/01/2019
 * @version 1.0
 */
@Service
public class EvaluateService {

    @Autowired
    private EvaluateDAO evaluateDAO;
    @Autowired
    private UttData uttData;
    

    /**
     * findById
     * @param SalaryTableId
     * @return
     */
    public EvaluateBO findById(Long evaluateId) {
        if (evaluateDAO.findById(evaluateId).isPresent()) {
            return evaluateDAO.findById(evaluateId).get();
        } else {
            return null;
        }
    }
    
    /**
     * findBySemesterAndYear
     * @param SalaryTableId
     * @return
     */
    public EvaluateBO findBySemesterAndYear(EvaluateForm form) {
        return evaluateDAO.findBySemesterAndYear(form.getUserId(), form.getSemester(), form.getYear(), uttData);
    }

    /**
     * statisticalEvaluate
     * @param SalaryTableId
     * @return
     */
    public List<Long> statisticalEvaluate() {
        return evaluateDAO.statisticalEvaluate(uttData);
    }

    /**
     * findByAll
     * @return
     */

    public List<EvaluateBO> findByAll() {
    	return evaluateDAO.findAll();
    }
    


    /**
     * saveOrUpdate
     * @param entity
     */
    @Transactional
    public void saveOrUpdate(EvaluateBO entity) {
        evaluateDAO.save(entity);
        uttData.flushSession();
    }
    

    /**
     * delete
     * @param entity
     */
    public void delete(EvaluateBO entity) {
        evaluateDAO.delete(entity);
    }

}
