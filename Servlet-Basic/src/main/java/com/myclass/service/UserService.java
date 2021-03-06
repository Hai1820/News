package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDto;
import com.myclass.entity.RoleEntity;
import com.myclass.entity.UserEntity;

public interface UserService {
	List<UserDto> findAllByJoin();

	int save(UserEntity entity);

	int update(UserEntity entity);

	void delete(long id);

	List<UserEntity> findAll();

	UserEntity findOne(long id);

	List<RoleEntity> findAllRole();

	UserDto checkLogin(String username, String password);
}
