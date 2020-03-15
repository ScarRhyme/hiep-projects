package com.report.criterion.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.report.criterion.bo.CriterionBO;
import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.report.criterion.bean.CriterionBean;
import com.report.criterion.form.CriterionForm;

/**
 * @author d2tsoftware
 * @since 09/01/2019
 * @version 1.0
 */
@Transactional
@Repository
public interface CriterionDAO extends CrudRepository<CriterionBO, Long> {

    /**
     * List all CriterionBO
     */
    public List<CriterionBO> findAll();
    

    /**
     * SELECT EmpPositionSalaryProcess by salaryTableId
     * @param salaryTableId
     */
    @Transactional
    @Query("SELECT e FROM CriterionBO e WHERE e.criterionId = :parentId")
    public CriterionBO findCriterionByParentId(@Param("parentId") Long parentId);

    /**
     * List findByParentIdOrderBySalaryTableIdAsc
     */
    public List<CriterionBO> findByParentIdOrderByCriterionIdAsc(Long parentId);

    /**
     * List findByParentIdOrderBySalaryTableIdAsc
     */
    @Transactional
    @Query("SELECT e FROM CriterionBO e WHERE e.parentId = :criterionId")
    public List<CriterionBO> findAllCriterionHaveParentIdWith(Long criterionId);
    
    /**
     * FindByCriterionType by criterionType
     */
    public CriterionBO findByCriterionType(Long criterionType);
    
    /*
     * get value by criterionId
     */
    @Query("SELECT value FROM CriterionBO WHERE criterionId = :criterionId")
    public String getValue(@Param("criterionId") Long criterionId);

    /**
     * getSalaryTableById
     */
    public default List<CriterionBO> getCriterionById(Long criterionId, UttData uttData, HttpServletRequest req) {
        String sql = "SELECT c.criterion_id As criterionId"
        		+ ",c.name As name"
        		+ " from criterions c "
                + " INNER JOIN criterions c1 on c.criterion_id = c1.parent_id "
                + " where c1.criterion_type = 2 and c.criterion_id = " + criterionId;

        SQLQuery query = uttData.createSQLQuery(sql);
        uttData.setResultTransformer(query, CriterionBO.class);
        return query.list();
    }

    /**
     * get data by datatable
     * 
     * @param vfData
     * @param SalaryTableForm
     * @return
     */
    public default DataTableResults<CriterionBean> getDatatables(UttData uttData, CriterionForm formData) {
        List<Object> paramList = new ArrayList<>();

        String sql = " SELECT ";
        sql += "        criterion_id As criertionId ";
        sql += "       ,code As code         ";
        sql += "       ,name As name         ";
        sql += "       ,value As value         ";
        sql += "       ,description As description  ";
        sql += "       ,criterion_type As criterionType    ";
        sql += "       ,parent_id As parentId     ";
        sql += "       ,created_date As createdDate  ";
        sql += "       ,created_by As createdBy    ";
        sql += "       FROM salary_table ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");

        CommonUtil.filter(formData.getCriterionId(), strCondition, paramList, "criterion_id");
        CommonUtil.filter(formData.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(formData.getName(), strCondition, paramList, "name");
        CommonUtil.filter(formData.getDescription(), strCondition, paramList, "description");
        CommonUtil.filter(formData.getParentId(), strCondition, paramList, "parent_id");

        String orderBy = " ORDER BY criertionId DESC ";
        return uttData.findPaginationQuery(sql + strCondition.toString(), orderBy, paramList, CriterionBean.class);
    }

    /**
     * List all SalaryTable. TH lay theo nation, hay lay theo parentId
     */
    public default List<CriterionBO> findByFilter(UttData uttData, Long parentId) {
        List<Object> paramList = new ArrayList<>();

        String sql = " SELECT ";
        sql += "        criterion_id As criterionId ";
        sql += "       ,code As code         ";
        sql += "       ,name As name         ";
        sql += "       ,value As value         ";
        sql += "       ,description As description  ";
        sql += "       ,criterion_type As criterionType    ";
        sql += "       ,parent_id As parentId     ";
        sql += "       ,created_date As createdDate  ";
        sql += "       ,created_by As createdBy    ";
        sql += "       FROM criterions ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");

        if (!CommonUtil.NVL(parentId).equals(0L)) {
            strCondition.append(" AND parent_id = ? ");
            paramList.add(parentId);
        }

        SQLQuery query = uttData.createSQLQuery(sql + strCondition.toString());
        if (!CommonUtil.isNullOrEmpty(paramList)) {
            int paramSize = paramList.size();
            for (int i = 0; i < paramSize; i++) {
                query.setParameter(i, paramList.get(i));
            }
        }
        uttData.setResultTransformer(query, CriterionBO.class);

        return query.list();
    }
    
    @Query("select c from CriterionBO c ")
    public List<CriterionBO> getAllData();
    
    public default List<CriterionBO> getAllData(UttData uttData, HttpServletRequest req) {
        String sql = "SELECT"
                   + " s.criterion_id As criterionId"
                   + ", s.code As code"
                   + ", s.name As name"
                   + ", s.value As value"
                   + ", s.description As description"
                   + ", s.criterion_type As criterionType"
                   + ", s.parent_id As parentId"
                   + " FROM criterions s"
                   + " WHERE 1=1";
        List<Object> paramList = new ArrayList<>();
        return uttData.list(sql, paramList, CriterionBO.class);
                   
    }
    
    public default List<CriterionBean> getAllEvaluateData(UttData uttData, HttpServletRequest req) {
        String sql = "SELECT"
                   + " s.criterion_id As criterionId"
                   + ", s.code As code"
                   + ", s.name As name"
                   + ", s.value As value"
                   + ", s.description As description"
                   + ", s.criterion_type As criterionType"
                   + ", s.parent_id As parentId"
                   + ", (SELECT count(*) FROM criterions crt WHERE crt.parent_id = s.criterion_id) As countChildren"
                   + ", s.criterion_level As criterionLevel"
                   + " FROM criterions s"
                   + " WHERE 1 = 1";
        List<Object> paramList = new ArrayList<>();
        return uttData.list(sql, paramList, CriterionBean.class);
                   
    }

}
