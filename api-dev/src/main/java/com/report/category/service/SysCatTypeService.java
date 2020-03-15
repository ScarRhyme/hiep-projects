package com.report.category.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.SysException;
import com.data.exception.ValidateException;
import com.report.category.bo.SysCatBO;
import com.report.category.bo.SysCatTypeBO;
import com.report.category.dao.SysCatDAO;
import com.report.category.dao.SysCatTypeDAO;
import com.report.category.form.SysCatTypeForm;


/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
@Service
public class SysCatTypeService {
	@Autowired
	private SysCatTypeDAO sysCatTypeDAO;
	@Autowired
	private SysCatDAO sysCatDAO;
	@Autowired
    private UttData uttData;

	public DataTableResults<SysCatTypeBO> findAllSysCatType(){
	    return sysCatTypeDAO.getDatatables(uttData);
	}
	/**
	 * Find sys cat type by id
	 * 
	 * @param sysCatTypeId id of sys cat type
	 * @return {@link SysCatTypeBO}
	 */
	public SysCatTypeBO findSysCatTypeById(Long sysCatTypeId) {
		return sysCatTypeDAO.findById(sysCatTypeId).get();
	}

	public void insertOrUpdate(SysCatTypeBO sysCatTypeBO) {
		sysCatTypeDAO.save(sysCatTypeBO);
	}

      /**
     * delete
     * @param entity
     */
    public void delete(SysCatTypeBO sysCatTypeBO) {
    	sysCatTypeDAO.delete(sysCatTypeBO);
    }


	public List<SysCatBO> getListSysCat(String code, HttpServletRequest req) {
		return sysCatDAO.findBySysCatTypeCode(uttData, code, req);
	}

	
	/**
	 * Check trùng SysCatType
	 * 
	 * @throws ValidateException
	 */
	public void validateBeforeSave(SysCatTypeBO bo, SysCatTypeForm form, HttpServletRequest req) throws SysException {
		// TODO Auto-generated method stub
		Long sysCatTypeId = CommonUtil.NVL(bo.getSysCatTypeId());
		String code = form.getCode();
		String name = form.getName();
		List<SysCatTypeBO> lstConflictedSysCatType;
		if (sysCatTypeId > 0L) {
			lstConflictedSysCatType = sysCatTypeDAO.findConfinctedSysCatType(sysCatTypeId, code, name);
		} else {
			lstConflictedSysCatType = sysCatTypeDAO.findConfinctedSysCatType(code, name);
		}
		if (!CommonUtil.isNullOrEmpty(lstConflictedSysCatType)) {
			throw new ValidateException("sysCatType.duplicateCode");
		}
	}
}
