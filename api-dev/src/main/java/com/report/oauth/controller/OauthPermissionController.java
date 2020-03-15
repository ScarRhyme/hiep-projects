package com.report.oauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.data.controller.BaseController;
import com.report.user.dao.UserDAO;

@Controller
public class OauthPermissionController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(OauthPermissionController.class);
    @Autowired
    private UserDAO sysUserDAO;

    /**
     * @param princal
     * @return
     */
//    @GetMapping("/utt-authorities")
//    public @ResponseBody Response authoritiesOf(OAuth2Authentication princal, @RequestParam String appCode) {
//        return Response.success().withData(sysUserDAO.getAuthorities(princal.getName(), appCode));
//    }
}