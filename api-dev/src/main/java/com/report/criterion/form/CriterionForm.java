/*
 * Copyright (C) 2010 Viettel Telecom. All rights reserved.
 * VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.report.criterion.form;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * SalaryTableForm class
 *
 * @author
 * @since 1.0
 * @version 1.0
 */
public class CriterionForm {

    private Long       criterionId;
    private String     code;
    private String     name;
    private String     value;
    private Date       effectiveDate;
    private Date       expiredDate;
    private String     description;
    private Long       criterionType;
    private Long       parentId;
    private Date       createdDate;
    private String     createdBy;
    private String       criterionLevel;
//    private Long       isGetAll;
//    private MultipartFile fileAttachment;

    
    public Long getCriterionId() {
        return criterionId;
    }

    
    public void setCriterionId(Long criterionId) {
        this.criterionId = criterionId;
    }

    /**
     * Set the "code" field value
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get the "code" field value
     * @return the field value
     */
    public String getCode() {
        return this.code;
    }


    /**
     * Set the "name" field value
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the "name" field value
     * @return the field value
     */
    public String getName() {
        return this.name;
    }


    /**
     * Set the "effectiveDate" field value
     * @param effectiveDate
     */
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * Get the "effectiveDate" field value
     * @return the field value
     */
    public Date getEffectiveDate() {
        return this.effectiveDate;
    }


    /**
     * Set the "expiredDate" field value
     * @param expiredDate
     */
    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    /**
     * Get the "expiredDate" field value
     * @return the field value
     */
    public Date getExpiredDate() {
        return this.expiredDate;
    }


    /**
     * Set the "description" field value
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the "description" field value
     * @return the field value
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Set the "parentId" field value
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * Get the "parentId" field value
     * @return the field value
     */
    public Long getParentId() {
        return this.parentId;
    }

    /**
     * Set the "createdDate" field value
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Get the "createdDate" field value
     * @return the field value
     */
    public Date getCreatedDate() {
        return this.createdDate;
    }


    /**
     * Set the "createdBy" field value
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Get the "createdBy" field value
     * @return the field value
     */
    public String getCreatedBy() {
        return this.createdBy;
    }


    
    public Long getCriterionType() {
        return criterionType;
    }


    
    public void setCriterionType(Long criterionType) {
        this.criterionType = criterionType;
    }


    
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }


    
    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
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

    
//    
//    public MultipartFile getFileAttachment() {
//        return fileAttachment;
//    }
//
//    
//    public void setFileAttachment(MultipartFile fileAttachment) {
//        this.fileAttachment = fileAttachment;
//    }

}
