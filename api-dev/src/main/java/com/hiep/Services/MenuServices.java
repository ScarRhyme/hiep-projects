package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.UttData;
import com.hiep.DAO.Respon.MenuRes;
import com.hiep.Entities.About;
import com.hiep.Entities.Menu;
import com.hiep.EntitiesRequest.AboutReq;
import com.hiep.EntitiesRequest.MenuReq;

@Service
public class MenuServices implements BaseServicesInterface<Menu, MenuReq, Integer> {
	@Autowired
	private MenuRes MenuRes;
	@Autowired
	private UttData uttData;

	@Override
	public Menu findById(Integer id) {
		if (MenuRes.findById(id).isPresent()) {
			return MenuRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Menu> getlist(MenuReq Entirequest) {
		// TODO Auto-generated method stub
		return MenuRes.findAll();
	}

	

	@Override
	public void saveOrUpdate(Menu entity) {
		MenuRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(Menu entity) {
		MenuRes.delete(entity);
	}



}
