package com.bootdo.sku.model;

import com.bootdo.common.model.BaseDO;
import lombok.Getter;
import lombok.Setter;


/**
 * 商品
 * 表名：md_sku
 * @author guodun
 * @date 2019-03-28 10:42:16
 */
@Getter
@Setter
public class SkuDO extends BaseDO {

	//
	private Integer id;
	//
	private String name;
	//
	private String code;
	//
	private String ean13;
	//
	private String createTime;
}
