package com.report.evaluate.bean;

import java.util.Date;
import java.util.HashMap;

/**
 * SalaryTableBean for table "salary_table"
 *
 * @author
 * @since 1.0
 * @version 1.0
 */
public class EvaluateBean {

    private Long       criterionId;
    private Long       evaluateId;
    private String     value;
    private Long       parentId;
    private Long       userId;
    private String     year;
    private String     semester;
    private HashMap<Long, Long> radio;
    private HashMap<Long, Long> checkbox;
    
    
    /**
     * @return the evaluateId
     */
    public Long getEvaluateId() {
        return evaluateId;
    }

    
    /**
     * @param evaluateId the evaluateId to set
     */
    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    /**
     * @return the criterionId
     */
    public Long getCriterionId() {
        return criterionId;
    }
    
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
    
    /**
     * @param criterionId the criterionId to set
     */
    public void setCriterionId(Long criterionId) {
        this.criterionId = criterionId;
    }
    
    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }


    
    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }


    
    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
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
     * @return the radio
     */
    public HashMap<Long, Long> getRadio() {
        return radio;
    }


    
    /**
     * @return the checkbox
     */
    public HashMap<Long, Long> getCheckbox() {
        return checkbox;
    }


    
    /**
     * @param parentId the parentId to set
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    
    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
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
     * @param radio the radio to set
     */
    public void setRadio(HashMap<Long, Long> radio) {
        this.radio = radio;
    }


    
    /**
     * @param checkbox the checkbox to set
     */
    public void setCheckbox(HashMap<Long, Long> checkbox) {
        this.checkbox = checkbox;
    }

    
}
