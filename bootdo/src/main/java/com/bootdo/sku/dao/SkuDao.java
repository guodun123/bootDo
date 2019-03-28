package com.bootdo.sku.dao;

import com.bootdo.sku.model.SkuDO;

import com.bootdo.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品
 * @author guodun
 * @date 2019-03-28 10:42:16
 */
@Mapper
public interface SkuDao  extends BaseDao<SkuDO> {

}
