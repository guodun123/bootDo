package com.bootdo.so.domain;

import com.bootdo.common.domain.BaseDO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 销售
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-26 17:36:08
 */
@Getter
@Setter
public class SoDO extends BaseDO {
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
