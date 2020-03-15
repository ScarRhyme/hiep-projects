package com.report.criterion.form;

import java.util.List;


/**
 * @author D2T-TanPTN
 * @since May 15, 2019
 * @version 1.0
 */
public class CriterionFormInput {
    private CriterionForm CriterionForm;

    private List<Long> listPositionSalary;
    private List<Long> listIdDelete;
    
    /**
     * @return the criterionForm
     */
    public CriterionForm getCriterionForm() {
        return CriterionForm;
    }

    
    /**
     * @param criterionForm the criterionForm to set
     */
    public void setCriterionForm(CriterionForm criterionForm) {
        CriterionForm = criterionForm;
    }

    /**
     * @return the listPositionSalary
     */
    public List<Long> getListPositionSalary() {
        return listPositionSalary;
    }

    
    /**
     * @param listPositionSalary the listPositionSalary to set
     */
    public void setListPositionSalary(List<Long> listPositionSalary) {
        this.listPositionSalary = listPositionSalary;
    }

    /**
     * @return the listIdDelete
     */
    public List<Long> getListIdDelete() {
        return listIdDelete;
    }

    /**
     * @param listIdDelete the listIdDelete to set
     */
    public void setListIdDelete(List<Long> listIdDelete) {
        this.listIdDelete = listIdDelete;
    }
}
