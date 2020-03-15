package com.report.category.bo;

import java.io.Serializable;

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
@Table(name = "sys_cat_type")
public class SysCatTypeBO implements Serializable {

    @Id
    @Column(name = "sys_cat_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sysCatTypeId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Long status;
    
//    @Column(name = "value")
//    private String value;

    /**
     * @return the sysCatTypeId
     */
    public Long getSysCatTypeId() {
        return sysCatTypeId;
    }

    /**
     * @param sysCatTypeId
     *            the sysCatTypeId to set
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
     * @param code
     *            the code to set
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
     * @param name
     *            the name to set
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
     * @param status
     *            the status to set
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
//    public void setValue(String value) {
//        this.value = value;
//    }
}
