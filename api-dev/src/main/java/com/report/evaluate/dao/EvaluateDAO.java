package com.report.evaluate.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
//import org.hibernate.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.common.UttData;
import com.report.evaluate.bo.EvaluateBO;

/**
 * @author TanPTN
 * @since 09/01/2019
 * @version 1.0
 */
@Transactional
@Repository
public interface EvaluateDAO extends CrudRepository<EvaluateBO, Long> {

    /**
     * List all SalaryTable
     */
    public List<EvaluateBO> findAll();


    /**
     * getSalaryTableById
     */
    public default List<EvaluateBO> getCriterionById(Long criterionId, UttData uttData, HttpServletRequest req) {
        String sql = "SELECT c.criterion_id As criterionId"
        		+ ",c.name As name"
        		+ " FROM criterions c "
                + " INNER JOIN criterions c1 on c.criterion_id = c1.parent_id "
                + " where c1.criterion_type = 2 and c.criterion_id = " + criterionId;

        SQLQuery query = uttData.createSQLQuery(sql);
        uttData.setResultTransformer(query, EvaluateBO.class);
        return query.list();
    }
    
    @Query("SELECT e FROM EvaluateBO e WHERE e.userId = :userId AND LOWER(e.semester) = LOWER(:semester) AND LOWER(e.year) = LOWER(:year) ") 
    public EvaluateBO findBySemesterAndYear(@Param("userId") Long userId, @Param("semester") String semester, @Param("year") String year);

    /**
     * findBySemesterAndYear
     */
    public default EvaluateBO findBySemesterAndYear(Long userId, String semester, String year, UttData uttData) {
        
        String sql = " FROM EvaluateBO e "
                + " WHERE e.userId = :userId "
                + " AND LOWER(e.semester) = LOWER(:semester)"
                + " AND LOWER(e.year) = LOWER(:year)";

        org.hibernate.Query query = uttData.createQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("semester", semester);
        query.setParameter("year", year);
        query.setMaxResults(1);
        return (EvaluateBO) query.uniqueResult();
    }
    
    /**
     * Thong ke
     */
    public default List<Long> statisticalEvaluate(UttData uttData) {
        String sql = " SELECT total_value FROM evaluate WHERE semester = 'HK2' AND year = 'Y4' ";

        SQLQuery query = uttData.createSQLQuery(sql);
//        uttData.setResultTransformer(query, EvaluateBO.class);
        return query.list();
    }
}
