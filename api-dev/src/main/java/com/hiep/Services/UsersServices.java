package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.hiep.DAO.Respon.UsersRes;
import com.hiep.Entities.Users;
import com.hiep.EntitiesRequest.UsersReq;

@Service
public class UsersServices implements BaseServicesInterface<Users, UsersReq, Integer> {
	@Autowired
	private UsersRes UsersRes;
	@Autowired
	private UttData uttData;

	@Override
	public Users findById(Integer id) {
		if (UsersRes.findById(id).isPresent()) {
			return UsersRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Users> getlist(UsersReq Entirequest) {
		// TODO Auto-generated method stub
		return UsersRes.findAll();
	}

	@Override
	public void saveOrUpdate(Users entity) {
		UsersRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(Users entity) {
		UsersRes.delete(entity);
	}

}
