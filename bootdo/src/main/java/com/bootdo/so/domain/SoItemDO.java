package com.bootdo.so.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-26 17:36:08
 */
@Getter
@Setter
public class SoItemDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
