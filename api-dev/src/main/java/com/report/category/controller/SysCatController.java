package com.report.category.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.data.controller.BaseController;
import com.data.domain.DataTableResults;
import com.data.exception.SysException;
import com.report.category.bo.SysCatBO;
import com.report.category.form.SysCatForm;
import com.report.category.service.SysCatService;
import com.report.user.service.JwtService;
/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */	
@Controller
@RequestMapping("/utt-ess/sys-cats")
public class SysCatController extends BaseController{

    private static String adResouceKey = "resource.sysCat";
    @Autowired
    private SysCatService service;
    
    @Autowired
    private JwtService jwtService;
//    @Autowired
//    private PermissionChecker permissionChecker;
//    @Autowired
//    private SysCatSource sysCatSource;
    

    @GetMapping(path = "/{id}")
    public @ResponseBody Response findById(HttpServletRequest req, @PathVariable Long id) {
        SysCatBO bo = service.findById(id);
        if (bo == null) {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }
        return Response.success().withData(bo);
    }

    @GetMapping(path = "/search")
    public @ResponseBody DataTableResults<SysCatBO> getDatatables(HttpServletRequest req, SysCatForm sysCatForm) {
        return service.getDatatables(sysCatForm, req);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Response create(HttpServletRequest req, @RequestBody SysCatForm form) 
            throws Exception, SysException {
        Long sysCatId = CommonUtil.NVL(form.getSysCatId());
        SysCatBO bo;
        if(sysCatId > 0L) {
            bo = service.findById(sysCatId);
            if(bo == null) {
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
//            if (!permissionChecker.hasPermission("action.update", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
        } else {
            bo = new SysCatBO();
//            if (!permissionChecker.hasPermission("action.insert", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
            bo.setSysCatTypeId(form.getSysCatTypeId());
            bo.setCreatedDate(new Date());
            
            bo.setCreatedBy(jwtService.getUsernameFromToken(form.getToken()));
        }
        service.validateBeforeSave(bo, form);
        bo.setCode(form.getCode());
        bo.setName(form.getName());
//        bo.setValue(form.getValue());
        bo.setSortOrder(form.getSortOrder());
        bo.setDescription(form.getDescription());
        bo.setStatus(form.getStatus());
        service.saveOrUpdate(bo);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(bo);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Response delete(HttpServletRequest req,@PathVariable Long id) throws SysException, InstantiationException, IllegalAccessException {
        if(id > 0L) {
            SysCatBO bo = service.findById(id);
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

    @GetMapping(path = "/find-sc/{sysCatTypeCode}")
    public @ResponseBody Response findSysCatBySysCatTypeCode(@PathVariable final String sysCatTypeCode, HttpServletRequest req) {
        List<SysCatBO> sysCatList = service.findSysCat(sysCatTypeCode, req);
        return Response.success().withData(sysCatList);
    }
}
