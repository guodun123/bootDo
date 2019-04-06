package com.bootdo.so.dao;

import com.bootdo.so.model.SoDO;

import com.bootdo.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 销售
 * @author guodun
 * @date 2019-04-06 11:36:46
 */
@Mapper
public interface SoDao  extends BaseDao<SoDO> {

}
