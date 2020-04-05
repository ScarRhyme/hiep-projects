package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.UttData;
import com.hiep.DAO.Respon.PermissionRes;
import com.hiep.Entities.Permission;
import com.hiep.EntitiesRequest.PermissionReq;

@Service
public class PermissionServices implements BaseServicesInterface<Permission, PermissionReq, Integer> {
	@Autowired
	private PermissionRes PermissionRes;
	@Autowired
	private UttData uttData;

	@Override
	public Permission findById(Integer id) {
		if (PermissionRes.findById(id).isPresent()) {
			return PermissionRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Permission> getlist(PermissionReq Entirequest) {
		// TODO Auto-generated method stub
		return PermissionRes.findAll();
	}

	@Override
	public void saveOrUpdate(Permission entity) {
		PermissionRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(Permission entity) {
		PermissionRes.delete(entity);
	}

}
