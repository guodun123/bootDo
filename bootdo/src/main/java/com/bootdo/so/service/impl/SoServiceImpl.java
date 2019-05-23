package com.bootdo.so.service.impl;

import com.alibaba.fastjson.JSON;
import com.bootdo.common.utils.CommonUtil;
import com.bootdo.common.utils.StringUtils;
import com.bootdo.so.dao.SoItemDao;
import com.bootdo.so.model.SoItemDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bootdo.so.dao.SoDao;
import com.bootdo.so.model.SoDO;
import com.bootdo.so.service.SoService;


@Service
public class SoServiceImpl implements SoService {
    @Autowired
    private SoDao soDao;
    @Autowired
    private SoItemDao soItemDao;

    @Override
    public SoDO getById(Integer id) {
        return soDao.getById(id);
    }

    @Override
    public List<SoDO> listByMap(Map<String, Object> map) {
        return soDao.listByMap(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return soDao.count(map);
    }

    @Override
    public int save(SoDO so) {
        this.insert(so);
        String code = CommonUtil.getDocCode("XSD", 0, so.getId().toString());
        String itemStr = so.getItemStr();
        so.setCode(code);
        this.update(so);
        if (StringUtils.isEmpty(itemStr)) {
            return 1;
        }
        List<SoItemDO> itemList = JSON.parseArray(itemStr, SoItemDO.class);
        for (SoItemDO soItemDO : itemList) {
            soItemDO.setSoId(so.getId());
            soItemDO.setCreateTime(new Date());
            soItemDao.insert(soItemDO);
        }
        return 1;
    }

    private int insert(SoDO so) {
        so.setCeateTime(new Date());
        return soDao.insert(so);
    }

    @Override
    public int update(SoDO so) {
        return soDao.update(so);
    }

    @Override
    public int remove(Integer id) {
        return this.batchRemove(new Integer[]{id});
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return soDao.batchRemove(ids);
    }

}
