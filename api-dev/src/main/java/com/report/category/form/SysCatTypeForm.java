package com.report.category.form;

import java.util.List;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
public class SysCatTypeForm {
    private Long sysCatTypeId;
    private String code;
    private String name;
    private String value;
    private Long status;

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
}
