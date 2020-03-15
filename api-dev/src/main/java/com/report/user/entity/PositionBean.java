package com.report.user.entity;

/**
 * @author TanPTN
 * @since 09/05/2019
 * @version 1.0
 */

public class PositionBean {
    
    private Long positionId;
    private String className;
    
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
}
