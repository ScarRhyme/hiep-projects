package com.report.evaluate.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

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
import com.data.common.Response;
import com.data.common.UttData;
import com.data.controller.BaseController;
import com.data.exception.SysException;
import com.report.criterion.bo.CriterionBO;
import com.report.criterion.service.CriterionService;
import com.report.evaluate.bean.EvaluateBean;
import com.report.evaluate.bo.CriterionEvaluateBO;
import com.report.evaluate.bo.EvaluateBO;
import com.report.evaluate.dao.CriterionEvaluateDAO;
import com.report.evaluate.form.CriterionEvaluateForm;
import com.report.evaluate.form.EvaluateForm;
import com.report.evaluate.service.CriterionEvaluateService;
import com.report.evaluate.service.EvaluateService;
import com.report.user.service.JwtService;
/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */	
@Controller
@RequestMapping("/utt-ess/evaluate")
public class EvaluateController extends BaseController{

    private static String adResouceKey = "resource.evaluate";
    
    @Autowired
    private EvaluateService service;
    
    @Autowired
    private CriterionEvaluateService ceService;
    
    @Autowired
    private CriterionService crtService;
    
    @Autowired
    private CriterionEvaluateDAO criterionEvaluateDAO;
    
    @Autowired
    private UttData uttData;
    
    @Autowired
    private JwtService jwtService;
    
//    @Autowired
//    private PermissionChecker permissionChecker;

    @PostMapping(path = "/find-evaluate")
    public @ResponseBody Response findBySemesterAndYear(@RequestBody EvaluateForm form) {
        EvaluateBO bo = service.findBySemesterAndYear(form);
        if (bo == null) {
            return null;
        }
        
        List<CriterionEvaluateBO> ceBo = ceService.findByEvaluateId(bo.getEvaluateId());

        return Response.success().withData(ceBo);
    }

//    @GetMapping(path = "/search")
//    public @ResponseBody DataTableResults<EvaluateBO> getDatatables(HttpServletRequest req, EvaluateForm evaluateForm) {
//        return service.getDatatables(evaluateForm, req);
//    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public @ResponseBody Response create(HttpServletRequest req, @RequestBody EvaluateForm form) 
            throws Exception, SysException {
        CriterionEvaluateForm ceForm = form.getDataFormModel();
        HashMap<Long, Long> mapCheckbox = ceForm.getCheckbox();
        HashMap<Long, Long> mapRadio = ceForm.getRadio();

        EvaluateBO bo ;
        if(form.getUserId() > 0L && !CommonUtil.isNullOrEmpty(form.getSemester()) 
                && !CommonUtil.isNullOrEmpty(form.getYear())) {
            bo = service.findBySemesterAndYear(form);
            if(bo == null) {
//                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
                bo = new EvaluateBO();

                bo.setUserId(form.getUserId());
                bo.setYear(form.getYear());
                bo.setSemester(form.getSemester());
                bo.setCreatedDate(new Date());
                bo.setCreatedBy(jwtService.getUsernameFromToken(form.getToken()));
            } else {
                bo.setModifiedDate(new Date());
                bo.setModifiedBy(jwtService.getUsernameFromToken(form.getToken()));
            }
            
            service.saveOrUpdate(bo);
            
            // Xử lý thêm/sửa tại CriterionEvaluate
            List<CriterionEvaluateBO> lstCeBo = ceService.findByEvaluateId(bo.getEvaluateId());
            Long totalValue = 0L;
            if (!CommonUtil.isNullOrEmpty(lstCeBo)) {
                ceService.deleteAll(lstCeBo);
                // Xử lý sửa tại CriterionEvaluate với checbox
                for(Map.Entry<Long, Long> entry : mapCheckbox.entrySet()) {
                    if (CommonUtil.NVL(entry.getValue()) > 0L) {
                        CriterionEvaluateBO cesBo = new CriterionEvaluateBO();
                        cesBo.setEvaluateId(bo.getEvaluateId());
                        cesBo.setCriterionId(entry.getKey());
                        criterionEvaluateDAO.save(cesBo);
                        uttData.flushSession();
                        uttData.clear();
                        String value = crtService.getValue(entry.getKey());
                        totalValue += Long.parseLong(value);
                    }
                }
                // Xử lý sửa tại CriterionEvaluate với radio
                for(Map.Entry<Long, Long> entry : mapRadio.entrySet()) {
                    if (CommonUtil.NVL(entry.getValue()) > 0L) {
                        CriterionEvaluateBO cesBo = new CriterionEvaluateBO();
                        cesBo.setEvaluateId(bo.getEvaluateId());
                        cesBo.setCriterionId(entry.getValue());
                        criterionEvaluateDAO.save(cesBo);
                        uttData.flushSession();
                        uttData.clear();
                        String value = crtService.getValue(entry.getKey());
                        totalValue += Long.parseLong(value);
                    } else {
                        return Response.warning(Constants.RESPONSE_CODE.WARNING);
                    }
                }
            } else {
                // Xử lý thêm tại CriterionEvaluate với checkbox
                for(Map.Entry<Long, Long> entry : mapCheckbox.entrySet()) {
                    if (CommonUtil.NVL(entry.getValue()) > 0L) {
                        CriterionEvaluateBO ceBo = new CriterionEvaluateBO();
                        ceBo.setEvaluateId(bo.getEvaluateId());
                        ceBo.setCriterionId(entry.getKey());
                        criterionEvaluateDAO.save(ceBo);
                        uttData.flushSession();
                        uttData.clear();
                        String value = crtService.getValue(entry.getKey());
                        totalValue += Long.parseLong(value);
                    }
                }
                // Xử lý thêm tại CriterionEvaluate với radio
                for(Map.Entry<Long, Long> entry : mapRadio.entrySet()) {
                    if (CommonUtil.NVL(entry.getValue()) > 0L) {
                        CriterionEvaluateBO ceBo = new CriterionEvaluateBO();
                        ceBo.setEvaluateId(bo.getEvaluateId());
                        ceBo.setCriterionId(entry.getValue());
                        criterionEvaluateDAO.save(ceBo);
                        uttData.flushSession();
                        uttData.clear();
                        String value = crtService.getValue(entry.getKey());
                        totalValue += Long.parseLong(value);
                    } else {
                        return Response.warning(Constants.RESPONSE_CODE.WARNING);
                    }
                }
            }
            bo.setTotalValue(totalValue);
            service.saveOrUpdate(bo);
            return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(bo);
        } else {
            return Response.error(Constants.RESPONSE_CODE.ERROR);
        }
        
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Response delete(HttpServletRequest req,@PathVariable Long id) throws SysException, InstantiationException, IllegalAccessException {
        if(id > 0L) {
            EvaluateBO bo = service.findById(id);
            if (bo != null) {
//                if (!permissionChecker.hasPermission("action.delete", adResouceKey, req)) {
//                    return Response.invalidPermission();
//                 }
                service.delete(bo);
                return Response.success(Constants.RESPONSE_CODE.DELETE_SUCCESS);
            } else {
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
        } else {
            return Response.error(Constants.RESPONSE_CODE.ERROR);
        }
    }
    
    /**
     * statisticalEvaluate
     * @return
     */
    @GetMapping(path = "/statistical-evaluate")
    public @ResponseBody Response statisticalEvaluate() {
        List<Long> lstTotalValue = service.statisticalEvaluate();
        if (lstTotalValue == null) {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }

        return Response.success().withData(lstTotalValue);
    }
}
