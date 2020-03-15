package com.data.common;

import java.util.Date;
import java.util.List;

import com.data.common.CommonUtil;

/**
 * Node cay Ajax dong.
 * 
 * @author 
 * @since 1.0
 * @version 1.0
 */
public class TreeNodeEvaluateBean {

    private Long nodeId;
    private Object data;
    private String label;
    private Date expiredDate;
    private String styleClass;
    private String icon = "glyphicons glyphicons-list-alt";
    private String expandedIcon = "glyphicons glyphicons-folder-open";
    private String collapsedIcon = "glyphicons glyphicons-folder-closed";
    private Long referenceNum;
    private boolean leaf = true;
    private boolean expanded = false;
    private List<TreeNodeEvaluateBean> children;

    /**
     * @return the nodeId
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     * @param nodeId
     *            the nodeId to set
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label
     *            the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     *            the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return the expandedIcon
     */
    public String getExpandedIcon() {
        return expandedIcon;
    }

    /**
     * @param expandedIcon
     *            the expandedIcon to set
     */
    public void setExpandedIcon(String expandedIcon) {
        this.expandedIcon = expandedIcon;
    }

    /**
     * @return the collapsedIcon
     */
    public String getCollapsedIcon() {
        return collapsedIcon;
    }

    /**
     * @param collapsedIcon
     *            the collapsedIcon to set
     */
    public void setCollapsedIcon(String collapsedIcon) {
        this.collapsedIcon = collapsedIcon;
    }

    /**
     * @return the referenceNum
     */
    public Long getReferenceNum() {
        return referenceNum;
    }

    /**
     * @param referenceNum
     *            the referenceNum to set
     */
    public void setReferenceNum(Long referenceNum) {
        this.referenceNum = referenceNum;
        if(CommonUtil.NVL(this.referenceNum) > 0L) {
            this.leaf = false;
        }
    }

    /**
     * @return the children
     */
    public List<TreeNodeEvaluateBean> getChildren() {
        return children;
    }

    /**
     * @param children
     *            the children to set
     */
    public void setChildren(List<TreeNodeEvaluateBean> children) {
        this.children = children;
    }

    /**
     * @return the expiredDate
     */
    public Date getExpiredDate() {
        return expiredDate;
    }

    /**
     * @param expiredDate
     *            the expiredDate to set
     */
    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    
    /**
     * @return the leaf
     */
    public boolean isLeaf() {
        return leaf;
    }

    /**
     * @param leaf the leaf to set
     */
    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    
    /**
     * @return the expanded
     */
    public boolean isExpanded() {
        return expanded;
    }

    
    /**
     * @param expanded the expanded to set
     */
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    
    /**
     * @return the styleClass
     */
    public String getStyleClass() {
        return styleClass;
    }

    
    /**
     * @param styleClass the styleClass to set
     */
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    
    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    
    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
}
