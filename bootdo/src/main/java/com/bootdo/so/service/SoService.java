package com.bootdo.so.service;

import com.bootdo.so.domain.SoDO;

import java.util.List;
import java.util.Map;

/**
 * 销售
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-26 17:36:08
 */
public interface SoService {
	
	SoDO get(Integer id);
	
	List<SoDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SoDO so);
	
	int update(SoDO so);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
