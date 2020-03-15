package com.report.averagescore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.type.LongType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.report.averagescore.bean.AverageScoreBean;
import com.report.averagescore.bo.AverageScoreBO;
import com.report.averagescore.form.AverageScoreForm;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0	
 */
@Transactional
@Repository
public interface AverageScoreDAO extends CrudRepository<AverageScoreBO, Long> {
    /**
     * List all sys_cat.
     */
    public List<AverageScoreBO> findAll();
    
    /**
     * Find by SysCatTypeId.
     * @param sysCatTypeId
     * @return
     */
    public List<AverageScoreBO> findByAverageScoreId(Long id);
    

    /**
     * get data by datatable
     * @param uttData
     * @return
     */
    
    public default DataTableResults<AverageScoreBean> getStudentListAS(UttData uttData, AverageScoreForm asForm, HttpServletRequest req) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = "SELECT "
                + "     usr.user_id AS userId " 
                + "     ,avs.average_score_id AS averageScoreId "
                + "     ,usr.full_name AS fullName "
                + "     ,usr.gender AS gender "
                + "     ,usr.date_of_birth AS dateOfBirth "
                + "     ,usr.email AS email "
                + "     ,usr.mobile_number AS mobileNumber "
                + "     ,usr.user_code AS userCode "
                + "     ,pst.position_name AS className "
                + "     ,pst.position_id AS positionId "
                + "     ,mj.major_name AS majorName "
                + "     ,dpm.department_name AS departmentName "
                + "     ,avs.score AS score "
                + " FROM users usr "
                + " INNER JOIN roles rls ON usr.role_id = rls.role_id "
                + " LEFT JOIN position pst ON usr.position_id = pst.position_id "
                + " INNER JOIN majors mj ON pst.major_id = mj.major_id "
                + " INNER JOIN departments dpm ON mj.department_id = dpm.department_id  "
                + " LEFT JOIN average_scores avs ON usr.user_id = avs.user_id  ";

        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 AND usr.role_id = 2");
        
        CommonUtil.filter(asForm.getUserCode(), strCondition, paramList, "usr.user_code");
        CommonUtil.filter(asForm.getFullName(), strCondition, paramList, "usr.full_name");
        CommonUtil.filter(asForm.getPositionId(), strCondition, paramList, "pst.position_id");
        CommonUtil.filter(asForm.getSemester(), strCondition, paramList, "avs.semester");
        CommonUtil.filter(asForm.getYear(), strCondition, paramList, "avs.year");

        String orderBy = " ORDER BY userId DESC ";
        return uttData.findPaginationQuery(nativeSQL + strCondition.toString(), orderBy, paramList, AverageScoreBean.class);
    }
    
    public default String getDepartmentName(UttData uttData, Long positionId) {
        String nativeSQL = "SELECT dpm.department_name "
                + " FROM position pst"
                + " INNER JOIN majors mj ON pst.major_id = mj.major_id"
                + " INNER JOIN departments dpm ON mj.department_id = dpm.department_id  "
                + " WHERE 1 = 1 AND  pst.position_id = :positionId ";
        SQLQuery query = uttData.createSQLQuery(nativeSQL);
        query.setParameter("positionId", positionId);
        return (String) query.uniqueResult();
    }

    /**
     * Hàm kiểm tra học sinh đã tồn tại với học kỳ và năm
     *
     * @param Date issueDate
     * @param Long employeeId
     * @param Date expirationDate
     * @param Long citizenshipPassportId
     * @return
     */
    public default Boolean validateUserExist(String semester, String year, Long userId, UttData uttData) {
        String sql = " SELECT "
                   + " COUNT(*) AS count "
                   + " FROM average_scores AS ass "
                   + " WHERE 1 = 1 "
                   + " AND LOWER(ass.semester) = LOWER(:semester) "
                   + " AND LOWER(ass.year) = LOWER(:year) "
                   + " AND ass.user_id = :userId ";

        SQLQuery query = uttData.createSQLQuery(sql);
        query.setParameter("semester", semester);
        query.setParameter("year", year);
        if (CommonUtil.NVL(userId) > 0L) {
            query.setParameter("userId", userId);
        }
        query.addScalar("count", LongType.INSTANCE);
        query.setMaxResults(1);
        Long count = (Long) query.uniqueResult();
        return count > 0L;
    }
    
    public default List<Long> statisticalAverageScore(UttData uttData) {
        String sql = " SELECT score FROM average_scores WHERE semester = 'HK2' AND year = 'Y4' ";

        SQLQuery query = uttData.createSQLQuery(sql);
        return query.list();
    }
}
