package com.report.category.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
@Entity
@Table(name = "sys_cat")
public class SysCatBO implements Serializable {
    @Id
    @Column(name = "sys_cat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sysCatId;

    @Column(name = "sys_cat_type_id")
    private Long sysCatTypeId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

//    @Column(name = "value")
//    private String value;

    @Column(name = "sort_order")
    private Long sortOrder;

    @Column(name = "description")
    private String description;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "status")
    private Long status;
    

    
    /**
     * @return the sysCatId
     */
    public Long getSysCatId() {
        return sysCatId;
    }

    
    /**
     * @param sysCatId the sysCatId to set
     */
    public void setSysCatId(Long sysCatId) {
        this.sysCatId = sysCatId;
    }

    
    /**
     * @return the sysCatTypeId
     */
    public Long getSysCatTypeId() {
        return sysCatTypeId;
    }

    
    /**
     * @param sysCatTypeId the sysCatTypeId to set
     */
    public void setSysCatTypeId(Long sysCatTypeId) {
        this.sysCatTypeId = sysCatTypeId;
    }

    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    
    /**
     * @return the sortOrder
     */
    public Long getSortOrder() {
        return sortOrder;
    }


    
    /**
     * @param sortOrder the sortOrder to set
     */
    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    
    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    
    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    
    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    
    /**
     * @return the status
     */
    public Long getStatus() {
        return status;
    }

    
    /**
     * @param status the status to set
     */
    public void setStatus(Long status) {
        this.status = status;
    }


//    
//    public String getValue() {
//        return value;
//    }
//
//
//    
//    public void setValue(String value) {
//        this.value = value;
//    }

}
