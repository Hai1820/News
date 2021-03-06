package com.myclass.repository;

import java.util.List;

import com.myclass.dto.UserDto;
import com.myclass.entity.RoleEntity;
import com.myclass.entity.UserEntity;

public interface UserRepository extends GenericRepository<UserEntity> {
	List<UserDto> findAllUser();

	List<RoleEntity> findAllRole();

	UserEntity findByUsername(String username);

	RoleEntity findByRoleId(long id);
}
