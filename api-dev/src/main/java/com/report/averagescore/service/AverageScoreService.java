package com.report.averagescore.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.report.averagescore.bean.AverageScoreBean;
import com.report.averagescore.bo.AverageScoreBO;
import com.report.averagescore.dao.AverageScoreDAO;
import com.report.averagescore.form.AverageScoreForm;


/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
@Service
public class AverageScoreService {	
    @Autowired
    private AverageScoreDAO asDAO;
    
    @Autowired
    private UttData uttData;

    public AverageScoreBO findById(Long id) {
    	if (asDAO.findById(id).isPresent()) {
            return asDAO.findById(id).get();
    	} else {
    		return null;
    	}

    }
    

    @Transactional
    public void saveOrUpdate(AverageScoreBO entity) {
        uttData.saveOrUpdate(entity);
        uttData.flushSession();
    }

    public void delete(AverageScoreBO entity) {
        asDAO.delete(entity);
    }

    public DataTableResults<AverageScoreBean> getDatatablesAS(AverageScoreForm asForm, HttpServletRequest req) {
        return asDAO.getStudentListAS(uttData, asForm, req);
    }
    
    public String getDeparmentName(Long positionId) {
        return asDAO.getDepartmentName(uttData, positionId);
    }
    
    public boolean validateUserExist(AverageScoreForm form, Long userId) {
        return asDAO.validateUserExist(form.getSemester(), form.getYear(), userId, uttData);
    }
    
    /**
     * statisticalAverageScore
     * @param SalaryTableId
     * @return
     */
    public List<Long> statisticalAverageScore() {
        return asDAO.statisticalAverageScore(uttData);
    }
}
