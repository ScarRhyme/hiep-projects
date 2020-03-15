package com.report.criterion.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.data.common.CommonUtil;
import com.data.common.Constants;
//import com.data.common.FileStorage;
import com.data.common.Response;
import com.data.common.TreeNodeBean;
import com.data.common.TreeNodeEvaluateBean;
import com.data.common.UttData;
import com.data.controller.BaseController;
import com.data.domain.DataTableResults;
import com.data.exception.SysException;
import com.report.criterion.bean.CriterionBean;
import com.report.criterion.bo.CriterionBO;
import com.report.criterion.dao.CriterionDAO;
import com.report.criterion.form.CriterionForm;
import com.report.criterion.service.CriterionService;


/**
 * @author d2tsoftware
 * @since 09/01/2019
 * @version 1.0
 */
@Controller
@RequestMapping("/utt-ess/criterion")
public class CriterionController extends BaseController {

    @Autowired
    private CriterionService criterionservice;

    @Autowired
    private CriterionDAO criterionDAO;
    
    @Autowired
    private UttData uttData;

    /**
     * findById
     * @param salaryTableId
     * @return
     */
    @GetMapping(path = "/{criterionId}")
    public @ResponseBody Response findById(@PathVariable Long criterionId) {
        CriterionBO criterionBO = criterionservice.findById(criterionId);
        if(criterionBO == null) {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }
        return Response.success().withData(criterionBO);
    }
   
    
    /**
     * getAll
     * @param 
     * @return
     */
    @GetMapping()
    public @ResponseBody Response getAll() {
        return Response.success().withData(criterionservice.findByAll());
    }
  
    
    /**
     * processSearch
     * @param SalaryTableForm form
     * @return DataTableResults
     */
    @GetMapping(path = "/search")
    public @ResponseBody DataTableResults<CriterionBean> processSearch(CriterionForm form) {
        return criterionservice.getDatatables(form);
    }

    /**
     * saveOrUpdate SalaryTableBO
     * @param req
     * @param form
     * @return
     * @throws Exception
     * @throws SysException 
     */
    @PostMapping()
    @Transactional
    public @ResponseBody Response saveOrUpdate(HttpServletRequest req, @RequestBody CriterionForm form) throws Exception, SysException {
        Long criterionId = CommonUtil.NVL(form.getCriterionId());
        CriterionBO criterionBO;
        if(criterionId > 0L) {
            criterionBO = criterionservice.findById(criterionId);
            if(criterionBO == null){
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
//            if(!permissionChecker.hasPermission("action.update", adResource, req)) {
//                return Response.invalidPermission();
//            }
        } else {
//            if(!permissionChecker.hasPermission("action.insert", adResource, req)) {
//                return Response.invalidPermission();
//            }
            criterionBO = new CriterionBO();
            criterionBO.setCreatedDate(new Date());
            criterionBO.setCreatedBy(CommonUtil.getUserLoginName(req));
        }

//        criterionservice.validateBeforeSave(form);
        criterionBO.setCode(form.getCode());
        criterionBO.setName(form.getName());
        criterionBO.setValue(form.getValue());
        criterionBO.setCriterionType(form.getCriterionType());
        criterionBO.setParentId(form.getParentId());
        criterionBO.setCriterionLevel(form.getCriterionLevel());

        criterionservice.saveOrUpdate(criterionBO);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(criterionBO);
    }


    /**
     * delete
     * @param salaryTableId
     * @return
     * @throws IOException 
     * @throws ParseException 
     * @throws SysException 
     */
    @DeleteMapping(path = "/{criterionId}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public @ResponseBody Response delete(HttpServletRequest req, @PathVariable Long criterionId) throws ParseException, IOException, SysException {
        CriterionBO bo ;
        if(criterionId > 0L) {
                bo = criterionservice.findById(criterionId);
                if(bo == null) {
                    return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
                }
//                if(!permissionChecker.hasPermission("action.delete", adResource, req)) {
//                    return Response.invalidPermission();
//                }
                
                if(bo.getCriterionType().equals(1L)) {
                    List<CriterionBO> lstCiterion = criterionDAO.findAllCriterionHaveParentIdWith(bo.getCriterionId());
                    if (!CommonUtil.isEmpty(lstCiterion)) {
                        for (CriterionBO criterionBO : lstCiterion) {
                            List<CriterionBO> lstCiterionChild = criterionDAO.findAllCriterionHaveParentIdWith(criterionBO.getCriterionId());
                            if (!CommonUtil.isEmpty(lstCiterionChild)) {
                                criterionDAO.deleteAll(lstCiterionChild);
                            }
                        }
                        criterionDAO.deleteAll(lstCiterion);
                    }
                    
                    criterionservice.delete(bo);
                    
                } else if (bo.getCriterionType().equals(2L)) {
                    List<CriterionBO> lstCiterionChild = criterionDAO.findAllCriterionHaveParentIdWith(bo.getCriterionId());
                    if (!CommonUtil.isEmpty(lstCiterionChild)) {
                        criterionDAO.deleteAll(lstCiterionChild);
                    }
                } else if(bo.getCriterionType().equals(3L)) {
                    criterionservice.delete(bo);
//                    CriterionBO parentBo = criterionservice.findById(bo.getParentId());
//                    if (parentBo != null && parentBo.getCriterionType().equals(1L)) {
//                        criterionDAO.deleteById(bo.getCriterionId());
//                    } else if (parentBo != null && parentBo.getCriterionType().equals(2L)) {
//                        criterionDAO.deleteById(bo.getCriterionId());
//                    }
                }
            return Response.success(Constants.RESPONSE_CODE.DELETE_SUCCESS);
            }
         else {
            return Response.error(Constants.RESPONSE_CODE.ERROR);
        }
    }

    /**
     * find tree criterion
     * @param 
     * @return
     */
    @PostMapping(path = "/criterion-tree")
    public @ResponseBody List<TreeNodeBean> findTreeCriterion(HttpServletRequest req) {
        List<TreeNodeBean> treeNodes = criterionservice.findTreeCriterion(req);
        return treeNodes;
    }
    
    /**
     * find tree criterion
     * @param 
     * @return
     */
    @PostMapping(path = "/criterion-evaluate-tree")
    public @ResponseBody List<TreeNodeEvaluateBean> findTreeCriterionEvaluate(HttpServletRequest req) {
        List<TreeNodeEvaluateBean> treeNodes = criterionservice.findTreeCriterionEvaluate(req);
        return treeNodes;
    }

}
