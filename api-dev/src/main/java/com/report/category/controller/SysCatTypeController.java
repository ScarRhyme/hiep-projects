package com.report.category.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
//import com.data.common.PermissionChecker;
import com.data.common.Response;
import com.data.controller.BaseController;
import com.data.domain.DataTableResults;
import com.data.exception.SysException;
import com.report.category.bo.SysCatBO;
import com.report.category.bo.SysCatTypeBO;
import com.report.category.dao.SysCatDAO;
import com.report.category.form.SysCatTypeForm;
import com.report.category.service.SysCatService;
import com.report.category.service.SysCatTypeService;

/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */
@Controller
@RequestMapping("/utt-ess/sys-cat-types")	
public class SysCatTypeController extends BaseController {
    private static String adResouceKey = "resource.sysCatType";
    @Autowired
    private SysCatTypeService sysCatTypeService;

    @Autowired
    private SysCatService sysCatService;

    @Autowired
    private SysCatDAO sysCatDAO;

//    @Autowired
//    private PermissionChecker permissionChecker;	
    
    @GetMapping(path = "/search")
    public @ResponseBody DataTableResults<SysCatTypeBO> getDatatables() {
        return sysCatTypeService.findAllSysCatType();
    }
    
    /**
     * find sys cat type by id
     * @param id id of sys cat type
     * @return
     */
    @GetMapping(path = "/{id}")
    // @PreAuthorize("hasPermission(returnObject, 'VPM', 'vpm_admin')")
    public @ResponseBody Response findById(@PathVariable final Long id) {
        SysCatTypeBO sysCatTypeBO = sysCatTypeService.findSysCatTypeById(id);
        if(sysCatTypeBO == null) {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }

        return Response.success().withData(sysCatTypeBO);
    }

    // API - write
    // @PreAuthorize("#oauth2.hasScope('write') and #oauth2.hasRole('vpm_admin')")
    @PostMapping()
    public @ResponseBody Response insertOrUpdate(@RequestBody SysCatTypeForm frm, HttpServletRequest request) throws Exception, SysException{
        SysCatTypeBO bo = new SysCatTypeBO();
        
        //check trung SysCatType
        sysCatTypeService.validateBeforeSave(bo, frm, request);
        CommonUtil.copyProperties(bo, frm);
        // check quyen
//        Long sysCatTypeId = CommonUtil.NVL(bo.getSysCatTypeId());
//        if(sysCatTypeId > 0L) {
//            if (!permissionChecker.hasPermission("action.update", adResouceKey, request)) {
//                return Response.invalidPermission();
//            }
//        } else {
//            if (!permissionChecker.hasPermission("action.insert", adResouceKey, request)) {
//                return Response.invalidPermission();
//            }
//        }
        sysCatTypeService.insertOrUpdate(bo);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(bo);
    }

    @GetMapping(path = "/paramUsed")
    public @ResponseBody Response listParamUsed() throws SysException, InstantiationException, IllegalAccessException {
    	List<Object> lstConstant = new ArrayList<Object>();
        for (Field field : Constants.SYS_CAT_TYPE.class.getDeclaredFields()) {
        Class<?> targetType = field.getType();
        Object objectValue = targetType.newInstance();
        Object value = field.get(objectValue);
        lstConstant.add(value);
        }
		return Response.success().withData(lstConstant);
    }

    /**
     * @param sysCatTypeId
     * @param req
     * @return
     * @throws IOException 
     * @throws ParseException 
     * @throws SysException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    @DeleteMapping(path = "/{sysCatTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Response delete(HttpServletRequest req, @PathVariable Long sysCatTypeId) throws ParseException, IOException, SysException, InstantiationException, IllegalAccessException {
         SysCatTypeBO sysCatTypeBO;
         List<Object> lstConstant = new ArrayList<Object>();
         for (Field field : Constants.SYS_CAT_TYPE.class.getDeclaredFields()) {
	         Class<?> targetType = field.getType();
	         Object objectValue = targetType.newInstance();
	         Object value = field.get(objectValue);
	         lstConstant.add(value);
         }
        if (sysCatTypeId > 0L) {
            sysCatTypeBO = sysCatTypeService.findSysCatTypeById(sysCatTypeId);
            if (sysCatTypeBO == null) {
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
//            if (! permissionChecker.hasPermission("action.delete", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
            if (lstConstant.contains(sysCatTypeBO.getCode())) {
                return Response.warning(Constants.RESPONSE_CODE.SYS_CAT_TYPE_USED);
            }
            List<SysCatBO> lstSc = sysCatService.findBySysCatTypeId(sysCatTypeId);
            if (!lstSc.isEmpty()) {
                sysCatDAO.deleteAll(lstSc);
            }
            sysCatTypeService.delete(sysCatTypeBO);
            return Response.success(Constants.RESPONSE_CODE.DELETE_SUCCESS);
        } else {
            return Response.error(Constants.RESPONSE_CODE.ERROR);
        }
    }

    /**
     * Lay danh sach sys cat theo sys-cat-type code
     * @param request
     * @return
     */
    @GetMapping(path = "/{code}/sys-cats")
    public @ResponseBody Response findSysCatByCode(HttpServletRequest req, @PathVariable String code) {
        List<SysCatBO> lst = sysCatTypeService.getListSysCat(code, req);
        return Response.success().withData(lst);
    }

}
