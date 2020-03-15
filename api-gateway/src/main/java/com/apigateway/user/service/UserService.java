package com.apigateway.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.apigateway.user.entity.PositionBO;
import com.apigateway.user.entity.PositionBean;
import com.apigateway.user.entity.RoleBO;
import com.apigateway.user.entity.UserBO;
import com.apigateway.user.entity.UserBean;
import com.apigateway.user.entity.UserForm;
import com.data.domain.DataTableResults;


/**
 * @author TanPTN
 * @since May 3, 2019
 * @version 1.0
 */

public interface UserService {
    
    UserBO save(UserBO user);
    void saveOrUpdate(UserBO user);
    List<UserBO> findAll();
    UserBO findById(Long id);
    void delete(UserBO bo);
    UserBean loadUserByUsername(String username);
    UserBean getUserByUsername(String username);
    UserBean getUserInfoById(Long userId);
    DataTableResults<UserBean> getStudentList(UserForm userForm, HttpServletRequest req);
    DataTableResults<UserBean> getDatatable(UserForm userForm, HttpServletRequest req);
    List<PositionBean> getClasses();
    List<UserBO> getListStudentByPositionId(Long positionId);
    PositionBO getClass(Long positionId);
    UserBO getUserByCode(String userCode);
    boolean checkLogin(UserForm user);
    public List<RoleBO> findAllRole();
}
