package com.report.evaluate.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.data.common.CommonUtil;

/**
 * @author TanPTN
 * @since 09/05/2019
 * @version 1.0
 */
@Entity
@Table(name = "evaluate")
public class EvaluateBO  implements Serializable{

    @Id
    @Column(name = "evaluate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evaluateId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_value")
    private Long totalValue;

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
     * @return the evaluateId
     */
    public Long getEvaluateId() {
        return evaluateId;
    }
    
    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }
    
    /**
     * @return the totalValue
     */
    public Long getTotalValue() {
        return totalValue;
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
     * @return the createDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }
    
    /**
     * @return the createBy
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
     * @param evaluateId the evaluateId to set
     */
    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
     * @param totalValue the totalValue to set
     */
    public void setTotalValue(Long totalValue) {
        this.totalValue = totalValue;
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
     * @param createDate the createDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    /**
     * @param createBy the createBy to set
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
