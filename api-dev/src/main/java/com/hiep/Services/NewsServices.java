package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.CommonUtil;
import com.data.common.UttData;
import com.data.domain.DataTableResults;
import com.data.exception.ValidateException;
import com.hiep.DAO.Respon.NewsRes;
import com.hiep.Entities.News;
import com.hiep.EntitiesRequest.NewsReq;

@Service
public class NewsServices implements BaseServicesInterface<News, NewsReq, Integer> {
	@Autowired
	private NewsRes NewsRes;
	@Autowired
	private UttData uttData;

	@Override
	public News findById(Integer id) {
		if (NewsRes.findById(id).isPresent()) {
			return NewsRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<News> getlist(NewsReq Entirequest) {
		// TODO Auto-generated method stub
		return NewsRes.findAll();
	}


	@Override
	public void saveOrUpdate(News entity) {
		NewsRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(News entity) {
		NewsRes.delete(entity);
	}



}
