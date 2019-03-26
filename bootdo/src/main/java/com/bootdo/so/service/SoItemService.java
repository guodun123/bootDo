package com.bootdo.so.service;

import com.bootdo.so.domain.SoItemDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-26 17:36:08
 */
public interface SoItemService {
	
	SoItemDO get(Integer id);
	
	List<SoItemDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SoItemDO soItem);
	
	int update(SoItemDO soItem);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
