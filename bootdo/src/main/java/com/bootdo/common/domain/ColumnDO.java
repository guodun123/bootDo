package com.bootdo.common.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 列的属性
 * 
 * 
 */
@Getter
@Setter
public class ColumnDO {
	// 列名
	private String columnName;
	// 列名类型
	private String dataType;
	// 列名备注
	private String comments;

	// 属性名称(第一个字母大写)，如：user_name => UserName
	private String attrName;
	// 属性名称(第一个字母小写)，如：user_name => userName
	private String attrname;
	// 属性类型
	private String attrType;
	// auto_increment
	private String extra;

	@Override
	public String toString() {
		return "ColumnDO{" +
				"columnName='" + columnName + '\'' +
				", dataType='" + dataType + '\'' +
				", comments='" + comments + '\'' +
				", attrName='" + attrName + '\'' +
				", attrname='" + attrname + '\'' +
				", attrType='" + attrType + '\'' +
				", extra='" + extra + '\'' +
				'}';
	}
}
