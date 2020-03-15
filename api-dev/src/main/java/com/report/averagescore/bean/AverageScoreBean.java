package com.report.averagescore.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * UserBean
 *
 * @author
 * @since 1.0
 * @version 1.0
 */
public class AverageScoreBean {

    private Long       userId;
    private Long       averageScoreId;
    private String     fullName;
    private String     dateOfBirth;
    private Long       gender;
    private String     email;
    private String     mobileNumber;
    private Long       positionId;
    private String     className;
    private String     majorName;
    private String     departmentName;
    private String     userCode;
    private String     semester;
    private String     year;
    private Double     score;
    
    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }
    
    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }
    
    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    
    /**
     * @return the gender
     */
    public Long getGender() {
        return gender;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * @return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    /**
     * @return the positionId
     */
    public Long getPositionId() {
        return positionId;
    }
    
    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }
    
    /**
     * @return the majorName
     */
    public String getMajorName() {
        return majorName;
    }
    
    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }
    
    /**
     * @return the userCode
     */
    public String getUserCode() {
        return userCode;
    }
    
    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }
    
    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    /**
     * @param gender the gender to set
     */
    public void setGender(Long gender) {
        this.gender = gender;
    }
    
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    /**
     * @param positionId the positionId to set
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }
    
    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }
    
    /**
     * @param majorName the majorName to set
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
    
    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    /**
     * @param userCode the userCode to set
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    
    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    
    /**
     * @return the score
     */
    public Double getScore() {
        return score;
    }

    
    /**
     * @param score the score to set
     */
    public void setScore(Double score) {
        this.score = score;
    }

    
    /**
     * @return the averageScoreId
     */
    public Long getAverageScoreId() {
        return averageScoreId;
    }

    
    /**
     * @param averageScoreId the averageScoreId to set
     */
    public void setAverageScoreId(Long averageScoreId) {
        this.averageScoreId = averageScoreId;
    }
    
}
