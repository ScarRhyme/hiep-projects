package com.hiep.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.data.common.CommonUtil;
import com.data.common.Constants;
import com.data.common.Response;
import com.data.exception.SysException;
import com.hiep.Entities.About;
import com.hiep.Entities.Actions;
import com.hiep.EntitiesRequest.AboutReq;
import com.hiep.EntitiesRequest.ActionsReq;
import com.hiep.Services.ActionsServices;
import com.report.user.service.JwtService;


@RestController
@RequestMapping("/dulich/actions")
public class ActionController {

	@Autowired
	private ActionsServices actionsServices;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping(path = "/{id}")
    public @ResponseBody Response findById(HttpServletRequest req, @PathVariable int id) {
		Actions actions = actionsServices.findById(id);
        if (actions == null) {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }
        return Response.success().withData(actions);
    }

    @GET
    public @ResponseBody List<Actions> getlist(HttpServletRequest req) {
    	List<Actions> listactions = actionsServices.getlist();
    	if(listactions.isEmpty() || listactions == null)
    	{
            return null ;
    	}
    	else {
    		return listactions;
    	}
    }

    @POST
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Response create(HttpServletRequest req, @RequestBody ActionsReq form) 
            throws Exception, SysException {
        int ActionID = CommonUtil.NVL(form.getActionId());
        Actions actions;
        if(ActionID > 0) {
        	actions = actionsServices.findById(ActionID);
            if(actions == null) {
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
//            if (!permissionChecker.hasPermission("action.update", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
        } else {
        	actions = new Actions();
//            if (!permissionChecker.hasPermission("action.insert", adResouceKey, req)) {
//                return Response.invalidPermission();
//            }
        	actions.setActionCode(form.getActionCode());
        	actions.setActionName(form.getActionName());
            // lấy token        	
            actionsServices.saveOrUpdate(actions);
        }
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(form);
    }
    
    @Path("/{id}")
    @DELETE
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Response delete(HttpServletRequest req,@PathVariable int id) throws SysException, InstantiationException, IllegalAccessException {
        if(id > 0L) {
            Actions actions = actionsServices.findById(id);
            if (actions != null) {

            	actionsServices.delete(actions);
                return Response.success(Constants.RESPONSE_CODE.DELETE_SUCCESS);
            } else {
                return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
            }
        } else {
            return Response.error(Constants.RESPONSE_CODE.ERROR);
        }
    }


@PostMapping(path = "/{id}")
@ResponseStatus(HttpStatus.OK)
public @ResponseBody Response update(HttpServletRequest req,@PathVariable int id) throws SysException, InstantiationException, IllegalAccessException {
    
	if(id > 0) {
		Actions actions = actionsServices.findById(id);

        if (actions != null) {

        	actionsServices.saveOrUpdate(actions);
            return Response.success(Constants.RESPONSE_CODE.DELETE_SUCCESS);
        } else {
            return Response.warning(Constants.RESPONSE_CODE.RECORD_DELETED);
        }
    } else {
        return Response.error(Constants.RESPONSE_CODE.ERROR);
    }
}
}
