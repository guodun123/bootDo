package com.bootdo.system.service;

import java.util.Collection;
import java.util.List;

import com.bootdo.system.model.UserDO;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Service;

import com.bootdo.system.model.UserOnline;

@Service
public interface SessionService {
	List<UserOnline> list();

	List<UserDO> listOnlineUser();

	Collection<Session> sessionList();
	
	boolean forceLogout(String sessionId);
}
