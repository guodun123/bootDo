package com.bootdo.so.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.so.dao.SoItemDao;
import com.bootdo.so.domain.SoItemDO;
import com.bootdo.so.service.SoItemService;



@Service
public class SoItemServiceImpl implements SoItemService {
	@Autowired
	private SoItemDao soItemDao;
	
	@Override
	public SoItemDO get(Integer id){
		return soItemDao.get(id);
	}
	
	@Override
	public List<SoItemDO> list(Map<String, Object> map){
		return soItemDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return soItemDao.count(map);
	}
	
	@Override
	public int save(SoItemDO soItem){
		soItem.setCreateTime(new Date());
		return soItemDao.save(soItem);
	}
	
	@Override
	public int update(SoItemDO soItem){
		return soItemDao.update(soItem);
	}
	
	@Override
	public int remove(Integer id){
		return soItemDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return soItemDao.batchRemove(ids);
	}
	
}
