package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.hiep.DAO.Respon.AboutRes;
import com.hiep.Entities.About;
import com.hiep.EntitiesRequest.AboutReq;

@Service
public class AboutServices implements BaseServicesInterface<About, AboutReq, Integer> {
	@Autowired
	private AboutRes aboutRes;
	@Autowired
	private UttData uttData;

	@Override
	public About findById(Integer id) {
		if (aboutRes.findById(id).isPresent()) {
			return aboutRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<About> getlist(AboutReq Entirequest) {
		// TODO Auto-generated method stub
		return aboutRes.findAll();
	}



	public List<About> findByTittle(String tittle) {
		return aboutRes.findbyTittle(tittle);
	}

	

	@Override
	public void saveOrUpdate(About entity) {
		aboutRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(About entity) {
		aboutRes.delete(entity);
	}



}
