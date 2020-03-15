package com.report.criterion.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.criterion.bo.CriterionBO;
//import com.viettel.bo.income.domain.SalaryTableDomain;
import com.data.common.CommonUtil;
import com.data.common.TreeNodeBean;
import com.data.common.TreeNodeEvaluateBean;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.SysException;
import com.data.exception.ValidateException;
import com.report.criterion.bean.CriterionBean;
import com.report.criterion.dao.CriterionDAO;
import com.report.criterion.form.CriterionForm;;
/**
 * @author 
 * @since 09/01/2019
 * @version 1.0
 */
@Service
public class CriterionService {

    @Autowired
    private CriterionDAO criterionDao;
    @Autowired
    private UttData uttData;
    

    /**
     * findById
     * @param criterionId
     * @return
     */
    public CriterionBO findById(Long criterionId) {
        if (criterionDao.findById(criterionId).isPresent()) {
            return criterionDao.findById(criterionId).get();
        } else {
            return null;
        }
    }

    /**
     * getValue
     * @param criterionId
     * @return
     */
    public String getValue(Long criterionId) {
        if (!CommonUtil.isNullOrEmpty(criterionDao.getValue(criterionId))) {
            return criterionDao.getValue(criterionId);
        } else {
            return null;
        }
    }
    

    
    /**
     * findByAll
     * @return
     */

    public List<CriterionBO> findByAll() {
    	return criterionDao.findAll();
    }
    
    /**
     * getDatatables
     * @param salaryTableForm
     * @return
     */
    public DataTableResults<CriterionBean> getDatatables(CriterionForm form) {
        return criterionDao.getDatatables(uttData, form);
    }

    /**
     * saveOrUpdate
     * @param entity
     */
    public void saveOrUpdate(CriterionBO entity) {
        criterionDao.save(entity);
        uttData.flushSession();
    }
    

    /**
     * delete
     * @param entity
     */
    public void delete(CriterionBO entity) {
        criterionDao.delete(entity);
    }

    /**
     * findTreeCriterion
     * @param 
     * @return
     */
    public List<TreeNodeBean> findTreeCriterion(HttpServletRequest req) {
        // TODO Auto-generated method stub
        List<CriterionBO> lscritetionBO = criterionDao.getAllData(uttData, req);
        Map<Long, List<CriterionBO>> mapParentId = new HashMap<>();
        
        for(CriterionBO criterionBO : lscritetionBO) {
            Long parent = CommonUtil.NVL(criterionBO.getParentId());
            List<CriterionBO> listChild = mapParentId.get(parent);
            if(listChild == null) {
                listChild = new ArrayList<>();
            }
            listChild.add(criterionBO);
            mapParentId.put(parent, listChild);
        }
        List<TreeNodeBean> lstBean = convertTreeNodeBean(mapParentId.get(0L));

        if(lstBean == null) {
            return null;
        }
        for(TreeNodeBean bean: lstBean) {
            createBean(bean, mapParentId);
        }
        return lstBean;
    }
    /**
     * createBean
     * @param bean
     * @return
     */
    public TreeNodeBean createBean(TreeNodeBean treeNodeBean, Map<Long, List<CriterionBO>> mapParentId) {
        List<CriterionBO> lstCriterionBO = mapParentId.get(treeNodeBean.getNodeId());
        List<TreeNodeBean> children = convertTreeNodeBean(lstCriterionBO);
        treeNodeBean.setChildren(children);
        if(children != null) {
            treeNodeBean.setReferenceNum(Long.valueOf(children.size()));
            for(TreeNodeBean bean: children) {
                createBean(bean, mapParentId);
            }
        } else {
            treeNodeBean.setReferenceNum(0L);
        }
        return treeNodeBean;
    }
    /**
     * convertTreeNodeBean
     * @param lstOrgDraffBO
     */
    public List<TreeNodeBean> convertTreeNodeBean(List<CriterionBO> lstalaryTableBO) {
        if (lstalaryTableBO == null) {
            return null;
        }
        List<TreeNodeBean> lstBean = new ArrayList<>();
        for (CriterionBO criterionBO : lstalaryTableBO) {
            TreeNodeBean bean = new TreeNodeBean();
            bean.setData("{ \"criterionId\": \"" + criterionBO.getCriterionId() + "\" , "
                         + " \"name\": \"" + criterionBO.getName() + "\" , "
                         + "\"criterionType\": \"" + criterionBO.getCriterionType().toString() + "\" , "
                         + "\"code\": \"" + criterionBO.getCode() + "\" , "
                         + "\"value\": \"" + criterionBO.getValue() + "\" , "
                         + "\"criterionLevel\": \"" + criterionBO.getCriterionLevel() + "\" "
                         + "}"
                        );
            bean.setNodeId(criterionBO.getCriterionId());
            bean.setLabel(criterionBO.getName());


            lstBean.add(bean);
        }
        return lstBean;
    }
    
    /**
     * findTreeCriterionEvaluate
     * @param 
     * @return
     */
    public List<TreeNodeEvaluateBean> findTreeCriterionEvaluate(HttpServletRequest req) {
        // TODO Auto-generated method stub
        List<CriterionBean> lscritetionBean = criterionDao.getAllEvaluateData(uttData, req);
        Map<Long, List<CriterionBean>> mapParentId = new HashMap<>();
        
        for(CriterionBean criterionBean : lscritetionBean) {
            Long parent = CommonUtil.NVL(criterionBean.getParentId());
            List<CriterionBean> listChild = mapParentId.get(parent);
            if(listChild == null) {
                listChild = new ArrayList<>();
            }
            listChild.add(criterionBean);
            mapParentId.put(parent, listChild);
        }
        List<TreeNodeEvaluateBean> lstBean = convertTreeNodeEvaluateBean(mapParentId.get(0L));

        if(lstBean == null) {
            return null;
        }
        for(TreeNodeEvaluateBean bean: lstBean) {
            createEvaluateBean(bean, mapParentId);
        }
        return lstBean;
    }
    /**
     * createBean
     * @param bean
     * @return
     */
    public TreeNodeEvaluateBean createEvaluateBean(TreeNodeEvaluateBean treeNodeBean, Map<Long, List<CriterionBean>> mapParentId) {
        List<CriterionBean> lstCriterionBO = mapParentId.get(treeNodeBean.getNodeId());
        List<TreeNodeEvaluateBean> children = convertTreeNodeEvaluateBean(lstCriterionBO);
        treeNodeBean.setChildren(children);
        if(children != null) {
            treeNodeBean.setReferenceNum(Long.valueOf(children.size()));
            for(TreeNodeEvaluateBean bean: children) {
                createEvaluateBean(bean, mapParentId);
            }
        } else {
            treeNodeBean.setReferenceNum(0L);
        }
        return treeNodeBean;
    }
    /**
     * convertTreeNodeBean
     * @param lstOrgDraffBO
     */
    public List<TreeNodeEvaluateBean> convertTreeNodeEvaluateBean(List<CriterionBean> lstCriterionBean) {
        if (lstCriterionBean == null) {
            return null;
        }
        List<TreeNodeEvaluateBean> lstBean = new ArrayList<>();
        for (CriterionBean criterionBean : lstCriterionBean) {
            TreeNodeEvaluateBean bean = new TreeNodeEvaluateBean();
            bean.setData(criterionBean);
            bean.setNodeId(criterionBean.getCriterionId());
            bean.setLabel(criterionBean.getName());


            lstBean.add(bean);
        }
        return lstBean;
    }

}
