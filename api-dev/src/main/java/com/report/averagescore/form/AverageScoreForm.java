package com.report.averagescore.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.report.criterion.bean.CriterionBean;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
public class AverageScoreForm {
    private Long averageScoreId;
    private Long userId;
    private String userCode;
    private String fullName;
    private Long positionId;
    private Double score;
    private String year;
    private String semester;
    private String token;
    private MultipartFile fileImport;
    
    /**
     * @return the averageScoreId
     */
    public Long getAverageScoreId() {
        return averageScoreId;
    }
    
    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }
    
    /**
     * @return the score
     */
    public Double getScore() {
        return score;
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
     * @param averageScoreId the averageScoreId to set
     */
    public void setAverageScoreId(Long averageScoreId) {
        this.averageScoreId = averageScoreId;
    }
    
    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    /**
     * @param score the score to set
     */
    public void setScore(Double score) {
        this.score = score;
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
     * @return the userCode
     */
    public String getUserCode() {
        return userCode;
    }

    
    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    
    /**
     * @return the positionId
     */
    public Long getPositionId() {
        return positionId;
    }

    
    /**
     * @param userCode the userCode to set
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    
    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    
    /**
     * @param positionId the positionId to set
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    
    /**
     * @return the fileImport
     */
    public MultipartFile getFileImport() {
        return fileImport;
    }

    
    /**
     * @param fileImport the fileImport to set
     */
    public void setFileImport(MultipartFile fileImport) {
        this.fileImport = fileImport;
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
