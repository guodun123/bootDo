package com.bootdo.common.dao;

import com.bootdo.common.domain.BaseDO;

import java.util.List;
import java.util.Map;

public interface BaseDao<T extends BaseDO> {
    T getById(Integer id);

    List<T> listByMap(Map<String,Object> map);

    int count(Map<String,Object> map);

    int insert(T var);

    int update(T var);

    int batchRemove(Integer[] ids);
}
