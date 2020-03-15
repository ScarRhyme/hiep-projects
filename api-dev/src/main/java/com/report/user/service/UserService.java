package com.report.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.data.domain.DataTableResults;
import com.report.user.entity.PositionBO;
import com.report.user.entity.PositionBean;
import com.report.user.entity.RoleBO;
import com.report.user.entity.UserBO;
import com.report.user.entity.UserBean;
import com.report.user.entity.UserForm;


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
