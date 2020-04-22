package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.UttData;
import com.hiep.DAO.Respon.BillDetailRes;
import com.hiep.Entities.BillDetail;
import com.hiep.EntitiesRequest.BillDetailReq;

@Service
public class BillDetailServices implements BaseServicesInterface<BillDetail, BillDetailReq, Integer> {
	@Autowired
	private BillDetailRes BillDetailRes;
	@Autowired
	private UttData uttData;

	@Override
	public BillDetail findById(Integer id) {
		if (BillDetailRes.findById(id).isPresent()) {
			return BillDetailRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<BillDetail> getlist() {
		// TODO Auto-generated method stub
		return BillDetailRes.findAll();
	}


	@Override
	public void saveOrUpdate(BillDetail entity) {
		BillDetailRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(BillDetail entity) {
		BillDetailRes.delete(entity);
	}

}
