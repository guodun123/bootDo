package com.bootdo.so.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.so.dao.SoDao;
import com.bootdo.so.model.SoDO;
import com.bootdo.so.service.SoService;



@Service
public class SoServiceImpl implements SoService {
	@Autowired
	private SoDao soDao;
	
	@Override
	public SoDO getById(Integer id){
		return soDao.getById(id);
	}
	
	@Override
	public List<SoDO> listByMap(Map<String, Object> map){
		return soDao.listByMap(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return soDao.count(map);
	}
	
	@Override
	public int save(SoDO so){
		return soDao.insert(so);
	}
	
	@Override
	public int update(SoDO so){
		return soDao.update(so);
	}
	
	@Override
	public int remove(Integer id){
		return this.batchRemove(new Integer[]{id});
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return soDao.batchRemove(ids);
	}
	
}
