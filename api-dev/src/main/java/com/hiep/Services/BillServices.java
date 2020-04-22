package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.UttData;
import com.hiep.DAO.Respon.BillRes;
import com.hiep.Entities.About;
import com.hiep.Entities.Bill;
import com.hiep.EntitiesRequest.AboutReq;
import com.hiep.EntitiesRequest.BillReq;

@Service
public class BillServices implements BaseServicesInterface<Bill, BillReq, Integer> {
	@Autowired
	private BillRes billRes;
	@Autowired
	private UttData uttData;

	@Override
	public Bill findById(Integer id) {
		if (billRes.findById(id).isPresent()) {
			return billRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Bill> getlist() {
		// TODO Auto-generated method stub
		return billRes.findAll();
	}

	

	@Override
	public void saveOrUpdate(Bill entity) {
		billRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(Bill entity) {
		billRes.delete(entity);
	}

}
