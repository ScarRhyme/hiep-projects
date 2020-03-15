package com.report.criterion.bo;

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
@Table(name = "criterions")
public class CriterionBO  implements Serializable{

    @Id
    @Column(name = "criterion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long criterionId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "description")
    private String description;

    @Column(name = "criterion_type")
    private Long criterionType;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "criterion_level")
    private String criterionLevel;

    public CriterionBO() {
    }
    public CriterionBO(CriterionBO bo, String name) throws Exception {
        if(bo != null) {
            CommonUtil.copyProperties(this, bo);
        }
        this.name = name;
    }

    
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
    public void setCode( String code ) {
        this.code = code ;
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
    public void setName( String name ) {
        this.name = name ;
    }

    /**
     * Get the "name" field value
     * @return the field value
     */
    public String getName() {
        return this.name;
    }

    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Set the "description" field value
     * @param description
     */
    public void setDescription( String description ) {
        this.description = description ;
    }

    /**
     * Get the "description" field value
     * @return the field value
     */
    public String getDescription() {
        return this.description;
    }

    
    public Long getCriterionType() {
        return criterionType;
    }
    
    public void setCriterionType(Long criterionType) {
        this.criterionType = criterionType;
    }
    /**
     * Set the "parentId" field value
     * @param parentId
     */
    public void setParentId( Long parentId ) {
        this.parentId = parentId ;
    }

    /**
     * Get the "parentId" field value
     * @return the field value
     */
    public Long getParentId() {
        return this.parentId;
    }

    public void setCreatedDate( Date createdDate ) {
        this.createdDate = createdDate ;
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
    public void setCreatedBy( String createdBy ) {
        this.createdBy = createdBy ;
    }

    /**
     * Get the "createdBy" field value
     * @return the field value
     */
    public String getCreatedBy() {
        return this.createdBy;
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
