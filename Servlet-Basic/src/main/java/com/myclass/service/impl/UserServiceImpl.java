package com.myclass.service.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.myclass.dto.UserDto;
import com.myclass.entity.RoleEntity;
import com.myclass.entity.UserEntity;
import com.myclass.repository.UserRepository;
import com.myclass.repository.impl.UserRepositoryImpl;
import com.myclass.service.UserService;

public class UserServiceImpl implements UserService {
	private UserRepository userRepository;

	public UserServiceImpl() {
		userRepository = new UserRepositoryImpl();
	}

	@Override
	public List<UserDto> findAllByJoin() {
		// TODO Auto-generated method stub
		return userRepository.findAllUser();
	}

	@Override
	public int save(UserEntity entity) {
		// TODO Auto-generated method stub
		return userRepository.insert(entity);
	}

	@Override
	public int update(UserEntity entity) {
		// TODO Auto-generated method stub
		return userRepository.update(entity);
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);

	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public UserEntity findOne(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public List<RoleEntity> findAllRole() {
		// TODO Auto-generated method stub
		return userRepository.findAllRole();
	}

	@Override
	public UserDto checkLogin(String username, String password) {
		UserEntity userEntity = userRepository.findByUsername(username);
		if (userEntity == null) {
			return null;
		}
		boolean result = BCrypt.checkpw(password, userEntity.getPassword());
		if (!result) {
			return null;
		}
		UserDto dto = new UserDto();
		if (userEntity != null && result) {
			RoleEntity roleEntity = userRepository.findByRoleId(userEntity.getRoleId());

			dto.setUserName(username);
			dto.setPassword(password);
			dto.setRoleName(roleEntity.getName());
		}

		return dto;
	}

}
