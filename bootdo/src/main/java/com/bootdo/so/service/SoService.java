package com.bootdo.so.service;

import com.bootdo.so.model.SoDO;

import java.util.List;
import java.util.Map;

/**
 * 销售
 * 
 * @author guodun
 * @date 2019-04-06 11:36:46
 */
public interface SoService {
    /**
    * id查询
	* @return
	*/
	SoDO getById(Integer id);

    /**
    * 按条件查询
	* @param map
	* @return
	*/
	List<SoDO> listByMap(Map<String, Object> map);

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
	int save(SoDO so);

    /**
    * 更新方法
	* @return
	*/
	int update(SoDO so);

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
