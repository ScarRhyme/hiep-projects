package com.report.category.form;


/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
public class SysCatForm {
    private Long sysCatId;
    private Long sysCatTypeId;
    private String code;
    private String name;
    private String value;
    private Long sortOrder;
    private String description;
    private Long status;
    private String token;
    
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

    
    public String getValue() {
        return value;
    }

    
    public void setValue(String value) {
        this.value = value;
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
