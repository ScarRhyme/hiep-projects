package com.report.criterion.bean;

import java.util.Date;
import java.util.List;

/**
 * SalaryTableBean for table "salary_table"
 *
 * @author
 * @since 1.0
 * @version 1.0
 */
public class CriterionBean {

    private Long       criterionId;
    private String     code;
    private String     name;
    private String     value;
    private String     description;
    private Long       criterionType;
    private Long       parentId;
    private Date       createdDate;
    private String     createdBy;
    private Long       countChildren;
    private String     criterionLevel;


    /**
     * Set the "salaryTableId" field value
     * @param salaryTableId
     */
    public void setCriterionId(Long criterionId) {
        this.criterionId = criterionId;
    }

    /**
     * Get the "salaryTableId" field value
     * @return the field value
     */
    public Long getCriterionId() {
        return this.criterionId;
    }

    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    
    /**
     * @return the criterionType
     */
    public Long getCriterionType() {
        return criterionType;
    }

    
    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
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
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    /**
     * @param criterionType the criterionType to set
     */
    public void setCriterionType(Long criterionType) {
        this.criterionType = criterionType;
    }

    
    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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
     * @return the countChildren
     */
    public Long getCountChildren() {
        return countChildren;
    }

    
    /**
     * @param countChildren the countChildren to set
     */
    public void setCountChildren(Long countChildren) {
        this.countChildren = countChildren;
    }

    
    /**
     * @return the criterionLevel
     */
    public String getCriterionLevel() {
        return criterionLevel;
    }

    
    /**
     * @param criterionLevel the criterionLevel to set
     */
    public void setCriterionLevel(String criterionLevel) {
        this.criterionLevel = criterionLevel;
    }

}
