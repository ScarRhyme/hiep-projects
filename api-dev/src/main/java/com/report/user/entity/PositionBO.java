package com.report.user.entity;

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
@Table(name = "position")
public class PositionBO  implements Serializable{

    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;

    @Column(name = "major_id")
    private Long majorId;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "positionCode")
    private String positionCode;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private Long isActive;

    @Column(name = "course")
    private String course;

    
    /**
     * @return the positionId
     */
    public Long getPositionId() {
        return positionId;
    }

    
    /**
     * @return the majorId
     */
    public Long getMajorId() {
        return majorId;
    }

    
    /**
     * @return the positionName
     */
    public String getPositionName() {
        return positionName;
    }

    
    /**
     * @return the positionCode
     */
    public String getPositionCode() {
        return positionCode;
    }

    
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    
    /**
     * @return the isActive
     */
    public Long getIsActive() {
        return isActive;
    }

    
    /**
     * @return the course
     */
    public String getCourse() {
        return course;
    }

    
    /**
     * @param positionId the positionId to set
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    
    /**
     * @param majorId the majorId to set
     */
    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    
    /**
     * @param positionName the positionName to set
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    
    /**
     * @param positionCode the positionCode to set
     */
    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    
    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    
    /**
     * @param course the course to set
     */
    public void setCourse(String course) {
        this.course = course;
    }

}
