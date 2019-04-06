package com.bootdo.so.model;

import com.bootdo.common.model.BaseDO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * 表名：doc_so_item
 * @author guodun
 * @date 2019-04-06 11:36:47
 */
@Getter
@Setter
public class SoItemDO extends BaseDO {

	//
	private Integer id;
	//
	private Integer soId;
	//
	private String skuName;
	//
	private Integer skuId;
	//
	private BigDecimal price;
	//
	private BigDecimal salaPrice;
	//
	private BigDecimal qty;
	//
	private Date createTime;
}
