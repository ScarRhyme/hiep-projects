package com.hiep.Services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.data.common.CommonUtil;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.report.category.bo.SysCatBO;
import com.report.category.form.SysCatForm;

public interface BaseServicesInterface<A, B, C> i {
	/*
	 * E là enity B là entity request C là DAO
	 */
	public A findById(C id);

	public DataTableResults<A> getDatatables(B Entirequest);

	public List<A> findByTypeId(C id);

	public List<A> findByName(String name);

	public String findByCode(String code);

	public void update(A object);

	public void saveOrUpdate(A entity);

	public void delete(A entity);

	/**
	 * Thuc hien validate truoc khi luu du lieu
	 * 
	 * @param entity
	 * @param entityRequest
	 * @throws ValidateException
	 */
	public void validateBeforeSave(A entity, B Entirequest) throws ValidateException;
	/**
	 * Lay danh sach sys cat type theo id cua thi truong va sys cat type code
	 * 
	 * @param nationId id cua thi truong
	 * @return danh sach {@link SysCatBO}
	 */
}
