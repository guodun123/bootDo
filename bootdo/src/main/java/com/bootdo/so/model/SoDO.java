package com.bootdo.so.model;

import com.bootdo.common.model.BaseDO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 销售
 * 表名：doc_so
 * @author guodun
 * @date 2019-04-06 11:36:46
 */
@Getter
@Setter
public class SoDO extends BaseDO {

	//
	private Integer id;
	//
	private String code;
	//
	private String phone;
	//
	private String address;
	//
	private String receiver;
	//快递号
	private String expressNo;
	//快递费
	private Date ceateTime;
	//
	private BigDecimal expressAmount;
	//订单金额
	private BigDecimal orderAmount;
	//支付方式
	private Integer payWay;
}
