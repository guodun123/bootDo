package com.bootdo.so.service;

import com.bootdo.so.model.SoItemDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author guodun
 * @date 2019-04-06 11:36:47
 */
public interface SoItemService {
    /**
    * id查询
	* @return
	*/
	SoItemDO getById(Integer id);

    /**
    * 按条件查询
	* @param map
	* @return
	*/
	List<SoItemDO> listByMap(Map<String, Object> map);

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
	int save(SoItemDO soItem);

    /**
    * 更新方法
	* @return
	*/
	int update(SoItemDO soItem);

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
