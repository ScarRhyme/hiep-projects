package com.report.evaluate.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.data.common.CommonUtil;

/**
 * @author TanPTN
 * @since 09/05/2019
 * @version 1.0
 */
@Entity
@Table(name = "criterion_evaluate")
public class CriterionEvaluateBO  implements Serializable{

    @Id
    @Column(name = "criterion_evaluate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long criterionEvaluateId;

    @Column(name = "evaluate_id")
    private Long evaluateId;

    @Column(name = "criterion_id")
    private Long criterionId;

    
    /**
     * @return the criterionEvaluateId
     */
    public Long getCriterionEvaluateId() {
        return criterionEvaluateId;
    }

    
    /**
     * @return the evaluateId
     */
    public Long getEvaluateId() {
        return evaluateId;
    }

    
    /**
     * @return the criterionId
     */
    public Long getCriterionId() {
        return criterionId;
    }

    
    /**
     * @param criterionEvaluateId the criterionEvaluateId to set
     */
    public void setCriterionEvaluateId(Long criterionEvaluateId) {
        this.criterionEvaluateId = criterionEvaluateId;
    }

    
    /**
     * @param evaluateId the evaluateId to set
     */
    public void setEvaluateId(Long evaluateId) {
        this.evaluateId = evaluateId;
    }

    
    /**
     * @param criterionId the criterionId to set
     */
    public void setCriterionId(Long criterionId) {
        this.criterionId = criterionId;
    }

}
