package com.data.domain;

import java.io.Serializable;

public class GrantedPermission implements Serializable {

    private static final long serialVersionUID = 6180160967562971380L;

    private String operationCode;
    private String resourceCode;
    private Long defaultDomain;
    private String grantedDomain;

    /**
     * @return the operationCode
     */
    public String getOperationCode() {
        return operationCode;
    }

    /**
     * @param operationCode
     *            the operationCode to set
     */
    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    /**
     * @return the resourceCode
     */
    public String getResourceCode() {
        return resourceCode;
    }

    /**
     * @param resourceCode
     *            the resourceCode to set
     */
    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public Long getDefaultDomain() {
        return defaultDomain;
    }

    public void setDefaultDomain(Long defaultDomain) {
        this.defaultDomain = defaultDomain;
    }

    public String getGrantedDomain() {
        return grantedDomain;
    }

    public void setGrantedDomain(String grantedDomain) {
        this.grantedDomain = grantedDomain;
    }

    @Override
    public String toString() {
        return "GrantedPermission [operationCode=" + operationCode + ", resourceCode=" + resourceCode + ", defaultDomain="
                + defaultDomain + ", grantedDomain=" + grantedDomain + "]";
    }

}
