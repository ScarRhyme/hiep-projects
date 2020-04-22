package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.UttData;
import com.hiep.DAO.Respon.CategoryRes;
import com.hiep.Entities.Category;
import com.hiep.EntitiesRequest.CategoryReq;

@Service
public class CategoryServices implements BaseServicesInterface<Category, CategoryReq, Integer> {
	@Autowired
	private CategoryRes CategoryRes;
	@Autowired
	private UttData uttData;

	@Override
	public Category findById(Integer id) {
		if (CategoryRes.findById(id).isPresent()) {
			return CategoryRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Category> getlist() {
		// TODO Auto-generated method stub
		return CategoryRes.findAll();
	}

	@Override
	public void saveOrUpdate(Category entity) {
		CategoryRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(Category entity) {
		CategoryRes.delete(entity);
	}

}
