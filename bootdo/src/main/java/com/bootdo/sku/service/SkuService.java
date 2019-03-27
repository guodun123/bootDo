package com.bootdo.sku.service;

import com.bootdo.sku.model.SkuDO;

import java.util.List;
import java.util.Map;

/**
 * 商品
 * 
 * @author guodun
 * @date 2019-03-27 13:39:00
 */
public interface SkuService {
    /**
    * id查询
	* @return
	*/
	SkuDO getById(Integer id);

    /**
    * 按条件查询
	* @param map
	* @return
	*/
	List<SkuDO> listByMap(Map<String, Object> map);

    /**
    * 配合listByMap 做到分页
	* @param map
	* @return
	*/
	int count(Map<String, Object> map);

    /**
    * 插入方法
	* @return
	*/
	int save(SkuDO sku);

    /**
    * 更新方法
	* @return
	*/
	int update(SkuDO sku);

    /**
    * 单条物理删除
	* @return
	*/
	int remove(Integer id);

    /**
    * 批量物理删除
	* @return
	*/
	int batchRemove(Integer[] ids);
}
