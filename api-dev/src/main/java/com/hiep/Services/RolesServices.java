package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.hiep.DAO.Respon.RolesRes;
import com.hiep.Entities.Roles;
import com.hiep.EntitiesRequest.RolesReq;

@Service
public class RolesServices implements BaseServicesInterface<Roles, RolesReq, Integer> {
	@Autowired
	private RolesRes RolesRes;
	@Autowired
	private UttData uttData;

	@Override
	public Roles findById(Integer id) {
		if (RolesRes.findById(id).isPresent()) {
			return RolesRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Roles> getlist(RolesReq Entirequest) {
		// TODO Auto-generated method stub
		return RolesRes.findAll();
	}




	@Override
	public void saveOrUpdate(Roles entity) {
		RolesRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(Roles entity) {
		RolesRes.delete(entity);
	}



}
