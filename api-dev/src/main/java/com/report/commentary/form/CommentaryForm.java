package com.report.commentary.form;

import java.util.List;

import com.report.criterion.bean.CriterionBean;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
public class CommentaryForm {
    private Long commentaryId;
    private Long userId;
    private String comment;
    private String year;
    private String semester;
    private String token;
    
    /**
     * @return the commentaryId
     */
    public Long getCommentaryId() {
        return commentaryId;
    }
    
    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }
    
    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }
    
    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }
    
    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }
    
    /**
     * @param commentaryId the commentaryId to set
     */
    public void setCommentaryId(Long commentaryId) {
        this.commentaryId = commentaryId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }
    
    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    
    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    
    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
    

}
