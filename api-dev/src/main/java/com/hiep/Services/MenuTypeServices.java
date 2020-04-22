package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.hiep.DAO.Respon.MenuTypeRes;
import com.hiep.Entities.MenuType;
import com.hiep.EntitiesRequest.MenuTypeReq;

@Service
public class MenuTypeServices implements BaseServicesInterface<MenuType, MenuTypeReq, Integer> {
	@Autowired
	private MenuTypeRes MenuTypeRes;
	@Autowired
	private UttData uttData;

	@Override
	public MenuType findById(Integer id) {
		if (MenuTypeRes.findById(id).isPresent()) {
			return MenuTypeRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<MenuType> getlist() {
		// TODO Auto-generated method stub
		return MenuTypeRes.findAll();
	}

	@Override
	public void saveOrUpdate(MenuType entity) {
		MenuTypeRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(MenuType entity) {
		MenuTypeRes.delete(entity);
	}

}
