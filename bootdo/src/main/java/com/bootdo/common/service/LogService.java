package com.bootdo.common.service;

import org.springframework.stereotype.Service;

import com.bootdo.common.model.LogDO;
import com.bootdo.common.model.PageDO;
import com.bootdo.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
