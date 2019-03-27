package com.bootdo.sku.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.sku.dao.SkuDao;
import com.bootdo.sku.model.SkuDO;
import com.bootdo.sku.service.SkuService;



@Service
public class SkuServiceImpl implements SkuService {
	@Autowired
	private SkuDao skuDao;
	
	@Override
	public SkuDO getById(Integer id){
		return skuDao.getById(id);
	}
	
	@Override
	public List<SkuDO> listByMap(Map<String, Object> map){
		return skuDao.listByMap(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return skuDao.count(map);
	}
	
	@Override
	public int save(SkuDO sku){
		return skuDao.insert(sku);
	}
	
	@Override
	public int update(SkuDO sku){
		return skuDao.update(sku);
	}
	
	@Override
	public int remove(Integer id){
		return this.batchRemove(new Integer[]{id});
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return skuDao.batchRemove(ids);
	}
	
}
