package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.hiep.DAO.Respon.TagsRes;
import com.hiep.Entities.Tags;
import com.hiep.EntitiesRequest.TagsReq;

@Service
public class TagsServices implements BaseServicesInterface<Tags, TagsReq, Integer> {
	@Autowired
	private TagsRes TagsRes;
	@Autowired
	private UttData uttData;

	@Override
	public Tags findById(Integer id) {
		if (TagsRes.findById(id).isPresent()) {
			return TagsRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Tags> getlist() {
		// TODO Auto-generated method stub
		return TagsRes.findAll();
	}



	@Override
	public void saveOrUpdate(Tags entity) {
		TagsRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(Tags entity) {
		TagsRes.delete(entity);
	}



}
