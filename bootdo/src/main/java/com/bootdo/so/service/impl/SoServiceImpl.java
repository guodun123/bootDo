package com.bootdo.so.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.so.dao.SoDao;
import com.bootdo.so.domain.SoDO;
import com.bootdo.so.service.SoService;



@Service
public class SoServiceImpl implements SoService {
	@Autowired
	private SoDao soDao;
	
	@Override
	public SoDO get(Integer id){
		return soDao.get(id);
	}
	
	@Override
	public List<SoDO> list(Map<String, Object> map){
		return soDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return soDao.count(map);
	}
	
	@Override
	public int save(SoDO so){
		return soDao.save(so);
	}
	
	@Override
	public int update(SoDO so){
		return soDao.update(so);
	}
	
	@Override
	public int remove(Integer id){
		return soDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return soDao.batchRemove(ids);
	}
	
}
