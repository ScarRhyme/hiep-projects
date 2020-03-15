package com.report.evaluate.form;

import java.util.HashMap;
import java.util.List;

import com.report.criterion.bean.CriterionBean;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
public class CriterionEvaluateForm {
    private HashMap<Long, Long> radio;
    private HashMap<Long, Long> checkbox;

    
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
