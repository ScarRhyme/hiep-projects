package com.hiep.EntitiesRequest;
// Generated Mar 16, 2020 10:55:25 AM by Hibernate Tools 5.4.7.Final

import java.util.Date;

import lombok.Data;

/**
 * Product generated by hbm2java
 */
@Data
public class ProductReq implements java.io.Serializable {

	private Integer productId;
	private String productCode;
	private String productName;
	private String metaTittle;
	private String descriptions;
	private Integer productImageId;
	private Integer price;
	private Integer promotionPrice;
	private Integer quantity;
	private Integer categoryId;
	private String detail;
	private Date createdDate;
	private String createBy;
	private String modifiedBy;
	private Date modifiedDate;
	private String metaKeywords;
	private String metaDescription;
	private Byte status;
	private Boolean topHot;
	private Integer viewCount;
	private Integer combo;
	private Integer productLocationId;
	private Date timeStart;
	private Date timeEnd;
	private Integer topHotDateAccept;

	public ProductReq() {
	}

	public ProductReq(String productCode, String productName, String metaTittle, String descriptions,
			Integer productImageId, Integer price, Integer promotionPrice, Integer quantity, Integer categoryId,
			String detail, Date createdDate, String createBy, String modifiedBy, Date modifiedDate, String metaKeywords,
			String metaDescription, Byte status, Boolean topHot, Integer viewCount, Integer combo,
			Integer productLocationId, Date timeStart, Date timeEnd, Integer topHotDateAccept) {
		this.productCode = productCode;
		this.productName = productName;
		this.metaTittle = metaTittle;
		this.descriptions = descriptions;
		this.productImageId = productImageId;
		this.price = price;
		this.promotionPrice = promotionPrice;
		this.quantity = quantity;
		this.categoryId = categoryId;
		this.detail = detail;
		this.createdDate = createdDate;
		this.createBy = createBy;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.metaKeywords = metaKeywords;
		this.metaDescription = metaDescription;
		this.status = status;
		this.topHot = topHot;
		this.viewCount = viewCount;
		this.combo = combo;
		this.productLocationId = productLocationId;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.topHotDateAccept = topHotDateAccept;
	}


}
