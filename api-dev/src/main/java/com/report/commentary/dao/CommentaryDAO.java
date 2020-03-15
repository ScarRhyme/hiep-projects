package com.report.commentary.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.data.common.UttData;
import com.report.commentary.bo.CommentaryBO;
import com.report.evaluate.bo.EvaluateBO;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0	
 */
@Transactional
@Repository
public interface CommentaryDAO extends CrudRepository<CommentaryBO, Long> {
    /**
     * List all sys_cat.
     */
    public List<CommentaryBO> findAll();
    
    /**
     * Find by SysCatTypeId.
     * @param sysCatTypeId
     * @return
     */
    public List<CommentaryBO> findByCommentaryId(Long id);

    @Query("SELECT c FROM CommentaryBO c WHERE c.userId = :userId AND LOWER(c.semester) = LOWER(:semester) AND LOWER(c.year) = LOWER(:year) ") 
    public CommentaryBO findComment(@Param("userId") Long userId, @Param("semester") String semester, @Param("year") String year);


    public default CommentaryBO findComment(Long userId, String semester, String year, UttData uttData) {
        
        String sql = " FROM CommentaryBO c "
                + " WHERE c.userId = :userId "
                + " AND LOWER(c.semester) = LOWER(:semester)"
                + " AND LOWER(c.year) = LOWER(:year)";
        
        org.hibernate.Query query = uttData.createQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("semester", semester);
        query.setParameter("year", year);
        query.setMaxResults(1);
        return (CommentaryBO) query.uniqueResult();
    }
}
