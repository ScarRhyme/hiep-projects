package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.hiep.DAO.Respon.CustomerRes;
import com.hiep.Entities.Customer;
import com.hiep.EntitiesRequest.CustomerReq;

@Service
public class CustomerServices implements BaseServicesInterface<Customer, CustomerReq, Integer> {
	@Autowired
	private CustomerRes CustomerRes;
	@Autowired
	private UttData uttData;

	@Override
	public Customer findById(Integer id) {
		if (CustomerRes.findById(id).isPresent()) {
			return CustomerRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Customer> getlist(CustomerReq Entirequest) {
		// TODO Auto-generated method stub
		return CustomerRes.findAll();
	}

	@Override
	public void saveOrUpdate(Customer entity) {
		CustomerRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(Customer entity) {
		CustomerRes.delete(entity);
	}

}
