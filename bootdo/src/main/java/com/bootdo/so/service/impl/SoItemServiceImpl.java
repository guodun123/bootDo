package com.bootdo.so.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.so.dao.SoItemDao;
import com.bootdo.so.model.SoItemDO;
import com.bootdo.so.service.SoItemService;



@Service
public class SoItemServiceImpl implements SoItemService {
	@Autowired
	private SoItemDao soItemDao;
	
	@Override
	public SoItemDO getById(Integer id){
		return soItemDao.getById(id);
	}
	
	@Override
	public List<SoItemDO> listByMap(Map<String, Object> map){
		return soItemDao.listByMap(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return soItemDao.count(map);
	}
	
	@Override
	public int save(SoItemDO soItem){
		return soItemDao.insert(soItem);
	}
	
	@Override
	public int update(SoItemDO soItem){
		return soItemDao.update(soItem);
	}
	
	@Override
	public int remove(Integer id){
		return this.batchRemove(new Integer[]{id});
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return soItemDao.batchRemove(ids);
	}
	
}
