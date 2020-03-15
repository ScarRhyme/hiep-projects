package com.report.category.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.report.category.bo.SysCatBO;
import com.report.category.dao.SysCatDAO;
import com.report.category.form.SysCatForm;


/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
@Service
public class SysCatService {	
    @Autowired
    private SysCatDAO scDAO;
    
    @Autowired
    private UttData uttData;

    public SysCatBO findById(Long id) {
    	if (scDAO.findById(id).isPresent()) {
            return scDAO.findById(id).get();
    	} else {
    		return null;
    	}

    }
    
    public List<SysCatBO> findBySysCatTypeId(Long id) {
        return scDAO.findBySysCatTypeId(id);
    }

    public String findByCode(String code) {
        return scDAO.findByCode(code);
    }
    
    public DataTableResults<SysCatBO> getDatatables(SysCatForm sysCatForm, HttpServletRequest req) {
        return scDAO.getDatatables(uttData, sysCatForm, req);
    }

    @Transactional
    public void saveOrUpdate(SysCatBO entity) {
        uttData.saveOrUpdate(entity);
        uttData.flushSession();
    }

    public void delete(SysCatBO entity) {
        scDAO.delete(entity);
    }

    /**
     * Thuc hien validate truoc khi luu du lieu
     * @param entity
     * @param form
     * @throws ValidateException 
     */
    public void validateBeforeSave(SysCatBO entity, SysCatForm form) throws ValidateException {
        List<SysCatBO> lstSysCat;
        if(CommonUtil.NVL(entity.getSysCatId()).equals(0L)) {
            lstSysCat = scDAO.findConflictedCode(form.getSysCatTypeId(), form.getCode());
        } else {
            lstSysCat = scDAO.findConflictedCode(entity.getSysCatId(), entity.getSysCatTypeId(), form.getCode());
        }
        if(!CommonUtil.isNullOrEmpty(lstSysCat)) {
            throw new ValidateException("sysCat.duplicateCode");
        }
    }
    /**
     * Lay danh sach sys cat type theo id cua thi truong va sys cat type code
     * 
     * @param nationId id cua thi truong
     * @return danh sach {@link SysCatBO}
     */
    public List<SysCatBO> findSysCat(String sysCatTypeCode, HttpServletRequest req) {
        return scDAO.findBySysCatTypeCode(uttData, sysCatTypeCode, req);
    }
}
