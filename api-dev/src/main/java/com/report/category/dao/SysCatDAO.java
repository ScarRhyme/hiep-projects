package com.report.category.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.report.category.bo.SysCatBO;
import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.report.category.form.SysCatForm;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0	
 */
@Transactional
@Repository
public interface SysCatDAO extends CrudRepository<SysCatBO, Long> {
    /**
     * List all sys_cat.
     */
    public List<SysCatBO> findAll();
    /**
     * Find by name.
     */
    public List<SysCatBO> findByName(String name);
    
    
    /**
     * Find by SysCatTypeId.
     * @param sysCatTypeId
     * @return
     */
    public List<SysCatBO> findBySysCatTypeId(Long sysCatTypeId);

    /**
     * Find list of code by sys cat type id.
     */
    @Query(value = "SELECT code FROM sys_cat WHERE sys_cat_type_id = (:sysCatTypeId)", nativeQuery = true)
    public List<String> findCodeListBySysCatTypeId(@Param("sysCatTypeId") Long sysCatTypeId);
    
    /**
     * Find list of code by sys cat type id.
     */
    @Query(value = "SELECT name FROM sys_cat WHERE code = (:code)", nativeQuery = true)
    public String findByCode(@Param("code") String code);

    /**
     * get data by datatable
     * @param vfData
     * @param sysCatForm
     * @return
     */
    
    public default DataTableResults<SysCatBO> getDatatables(UttData uttData, SysCatForm sysCatForm, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        
        String nativeSQL = "SELECT "
                + "     sc.sys_cat_id AS sysCatId "
                + "     ,sc.sys_cat_type_id AS sysCatTypeId "
                + "     ,sc.code AS code "
                + "     ,sc.name as name "
                + "     ,sc.value AS value "
                + "     ,sc.description AS description "
                + "     ,sc.created_date AS createdDate "
                + "     ,sc.created_by AS createdBy "
                + "     ,sc.status as status "
                + " FROM sys_cat sc "
                + " INNER JOIN sys_cat_type sct "
                + "     ON sc.sys_cat_type_id = sct.sys_cat_type_id";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        
        CommonUtil.filter(sysCatForm.getSysCatTypeId(), strCondition, paramList, "sc.sys_cat_type_id");
        CommonUtil.filter(sysCatForm.getCode(), strCondition, paramList, "sc.code");
        CommonUtil.filter(sysCatForm.getName(), strCondition, paramList, "sc.name");
//        CommonUtil.filter(sysCatForm.getStatus(), strCondition, paramList, "sc.status");

        String orderBy = " ORDER BY sysCatId DESC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, SysCatBO.class);
    }

    @Query("SELECT t FROM SysCatBO t where t.sysCatTypeId = :sysCatTypeId AND LOWER(t.code) = LOWER(:code) ") 
    public List<SysCatBO> findConflictedCode(@Param("sysCatTypeId") Long sysCatTypeId, @Param("code") String code);

    @Query("SELECT t FROM SysCatBO t where t.sysCatId != :sysCatId AND t.sysCatTypeId = :sysCatTypeId AND LOWER(t.code) = LOWER(:code) ") 
    public List<SysCatBO> findConflictedCode(@Param("sysCatId") Long sysCatId, @Param("sysCatTypeId") Long sysCatTypeId, @Param("code") String code);

    @Query("SELECT sc FROM SysCatBO sc, SysCatTypeBO sct where sc.sysCatTypeId = sct.sysCatTypeId AND LOWER(sct.code) = LOWER(:code) ") 
    public List<SysCatBO> findBySysCatTypeCode(@Param("code") String code);

//    @Query("SELECT sc FROM SysCatBO sc, SysCatTypeBO sct where sc.sysCatTypeId = sct.sysCatTypeId AND LOWER(sct.code) = LOWER(:code) AND sct.marketCompanyId = :marketCompanyId") 
//    public List<SysCatBO> findBySysCatTypeCodeAndMarketCompanyId(@Param("code") String code, @Param("marketCompanyId") Long marketCompanyId);
    
    public default List<SysCatBO> findBySysCatTypeCode(UttData uttData,String code, HttpServletRequest req) {

        String nativeSQL = "SELECT "
                        + "     sc.sys_cat_id AS sysCatId "
                        + "     ,sc.sys_cat_type_id AS sysCatTypeId "
                        + "     ,sc.code AS code "
                        + "     ,sc.name AS name "
                        + "     ,sc.sort_order AS sortOrder "
                        + "     ,sc.description AS description "
                        + "     ,sc.created_date AS createdDate "
                        + "     ,sc.created_by AS createdBy "
                        + "     ,sc.status as status "
                        + " FROM sys_cat sc "
                        + " INNER JOIN sys_cat_type sct "
                        + "     ON sc.sys_cat_type_id = sct.sys_cat_type_id "
                        + " WHERE 1 = 1 "
                        + "     AND LOWER(sct.code) = LOWER(:code)    ";

        SQLQuery query = uttData.createSQLQuery(nativeSQL);
        query.setParameter("code", code);

        uttData.setResultTransformer(query, SysCatBO.class);
        return query.list();
    }
}
