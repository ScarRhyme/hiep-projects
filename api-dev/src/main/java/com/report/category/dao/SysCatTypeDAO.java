package com.report.category.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.report.category.bo.SysCatBO;
import com.report.category.bo.SysCatTypeBO;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
@Transactional
@Repository
public interface SysCatTypeDAO extends CrudRepository<SysCatTypeBO, Long> {
    /**
     * List all sys_cat_type.	
     */
    public List<SysCatTypeBO> findAll();

    /**
     * get data by datatable
     * @param vfData
     * @param sysCatForm
     * @return
     */
    
    public default DataTableResults<SysCatTypeBO> getDatatables(UttData uttData) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     sct.sys_cat_type_id AS sysCatTypeId "
                + "     ,sct.code AS code "
                + "     ,sct.name as name "
                + "     ,sct.value AS value "
                + "     ,sct.created_date AS createdDate "
                + "     ,sct.created_by AS createdBy "
                + "     ,sct.status as status "
                + " FROM sys_cat_type sct ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");

        String orderBy = " ORDER BY code ASC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, SysCatTypeBO.class);
    }
    
    /**
     * Find by name.
     */
    public List<SysCatBO> findByName(String name);
    
    /**
     * findConfinctedSysCatType
     */
    @Query(" SELECT sct FROM SysCatTypeBO sct WHERE ( sct.code = :code OR sct.name = :name )")
    public List<SysCatTypeBO> findConfinctedSysCatType(@Param("code") String code, @Param("name") String name);
    
    @Query(" SELECT sct FROM SysCatTypeBO sct WHERE sct.sysCatTypeId != :sysCatTypeId AND ( sct.code = :code OR sct.name = :name )")
    public List<SysCatTypeBO> findConfinctedSysCatType(@Param("sysCatTypeId") Long sysCatTypeId, @Param("code") String code, @Param("name") String name);
    
}
