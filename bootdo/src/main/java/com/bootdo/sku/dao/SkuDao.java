package com.bootdo.sku.dao;

import com.bootdo.sku.model.SkuDO;

import com.bootdo.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品
 * @author guodun
 * @date 2019-03-27 13:39:00
 */
@Mapper
public interface SkuDao  extends BaseDao<SkuDO> {

}
