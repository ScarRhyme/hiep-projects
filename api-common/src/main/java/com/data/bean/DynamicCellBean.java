package com.data.bean;

/**
 * Doi tuong cell de export Excel dong.
 * @author TanPTN
 * @since 1.0
 * @version 1.0
 */
public class DynamicCellBean {

    /** ID cua hang */
    private Long rowId;
    /** ID cua cot */
    private Long columnId;
    /** Gia tri */
    private String text;

    public DynamicCellBean() {
    }

    public DynamicCellBean(Long rowId, Long columnId, String text) {
        this.rowId = rowId;
        this.columnId = columnId;
        this.text = text;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public Long getRowId() {
        return rowId;
    }

    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
