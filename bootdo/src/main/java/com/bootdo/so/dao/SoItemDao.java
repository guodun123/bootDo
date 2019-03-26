package com.bootdo.so.dao;


import java.util.List;
import java.util.Map;

import com.bootdo.so.domain.SoItemDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-26 17:36:08
 */
@Mapper
public interface SoItemDao {

	SoItemDO get(Integer id);
	
	List<SoItemDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(SoItemDO soItem);
	
	int update(SoItemDO soItem);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
