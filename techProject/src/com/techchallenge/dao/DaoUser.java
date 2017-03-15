package com.techchallenge.dao;

import com.techchallenge.domain.User;

public interface DaoUser {

	public void save(User user);
	public User findByUuid(String uuid);
	
	
}
