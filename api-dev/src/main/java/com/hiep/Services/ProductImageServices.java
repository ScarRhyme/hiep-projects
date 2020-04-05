package com.hiep.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.common.UttData;
import com.hiep.DAO.Respon.ProductImageRes;
import com.hiep.Entities.ProductImage;
import com.hiep.EntitiesRequest.ProductImageReq;

@Service
public class ProductImageServices implements BaseServicesInterface<ProductImage, ProductImageReq, Integer> {
	@Autowired
	private ProductImageRes ProductImageRes;
	@Autowired
	private UttData uttData;

	@Override
	public ProductImage findById(Integer id) {
		if (ProductImageRes.findById(id).isPresent()) {
			return ProductImageRes.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<ProductImage> getlist(ProductImageReq Entirequest) {
		// TODO Auto-generated method stub
		return ProductImageRes.findAll();
	}

	

	@Override
	public void saveOrUpdate(ProductImage entity) {
		ProductImageRes.save(entity);
		uttData.flushSession();
	}

	@Override
	public void delete(ProductImage entity) {
		ProductImageRes.delete(entity);
	}



}
