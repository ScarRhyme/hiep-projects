package com.report.commentary.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.data.common.CommonUtil;

/**
 * @author TanPTN
 * @since 09/05/2019
 * @version 1.0
 */
@Entity
@Table(name = "commentary")
public class CommentaryBO  implements Serializable{

    @Id
    @Column(name = "commentary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentaryId;

    @Column(name = "user_id")
    private Long userId;

    @Lob
    @Column(name = "comment")
    private String comment;

    @Column(name = "year")
    private String year;

    @Column(name = "semester")
    private String semester;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;
    
    
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
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    
    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    
    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    
    /**
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
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
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    
    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    
    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    
}
