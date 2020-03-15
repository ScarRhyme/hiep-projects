package com.report.commentary.controller;

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
import com.data.exception.SysException;
import com.report.category.bo.SysCatBO;
import com.report.commentary.bo.CommentaryBO;
import com.report.commentary.form.CommentaryForm;
import com.report.commentary.service.CommentaryService;
import com.report.user.service.JwtService;
/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */	
@Controller
@RequestMapping("/utt-ess/commentary")
public class CommentaryController extends BaseController{

    private static String adResouceKey = "resource.commentary";
    @Autowired
    private CommentaryService service;
    
    @Autowired
    private JwtService jwtService;
//    @Autowired
//    private PermissionChecker permissionChecker;

    

    @GetMapping(path = "/{id}")
    public @ResponseBody Response findById(HttpServletRequest req, @PathVariable Long id) {
        CommentaryBO bo = service.findById(id);
        if (bo == null) {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }
        return Response.success().withData(bo);
    }

//    @GetMapping(path = "/search")
//    public @ResponseBody DataTableResults<CommentaryBO> getDatatables(HttpServletRequest req, CommentaryForm sysCatForm) {
//        return service.getDatatables(CommentaryForm, req);
//    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Response create(HttpServletRequest req, @RequestBody CommentaryForm form) 
            throws Exception, SysException {
        Long commentaryId = CommonUtil.NVL(form.getCommentaryId());
        CommentaryBO bo;
        if(commentaryId > 0L) {
            bo = service.findById(commentaryId);
            if(bo == null) {
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
//            if (!permissionChecker.hasPermission("action.update", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
            bo.setModifiedDate(new Date());
            bo.setModifiedBy(jwtService.getUsernameFromToken(form.getToken()));
        } else {
            bo = new CommentaryBO();
//            if (!permissionChecker.hasPermission("action.insert", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
            bo.setCommentaryId(form.getCommentaryId());
            bo.setCreatedDate(new Date());
            
            bo.setCreatedBy(jwtService.getUsernameFromToken(form.getToken()));
        }
        bo.setUserId(form.getUserId());
        bo.setComment(form.getComment());
        bo.setSemester(form.getSemester());
        bo.setYear(form.getYear());
        service.saveOrUpdate(bo);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(bo);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Response delete(HttpServletRequest req,@PathVariable Long id) throws SysException, InstantiationException, IllegalAccessException {
        if(id > 0L) {
            CommentaryBO bo = service.findById(id);
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

    @PostMapping(path = "/find-comment")
    public @ResponseBody Response findComment(@RequestBody CommentaryForm form) {
        CommentaryBO commentaryBO = service.findComment(form);
        return Response.success().withData(commentaryBO);
    }
}
