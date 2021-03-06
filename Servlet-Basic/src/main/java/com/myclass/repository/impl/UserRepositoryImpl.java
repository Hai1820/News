package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.myclass.dbconnection.MysqlConnection;
import com.myclass.dto.UserDto;
import com.myclass.entity.RoleEntity;
import com.myclass.entity.UserEntity;
import com.myclass.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

	@Override
	public List<UserEntity> findAll() {
		Connection connection = MysqlConnection.getConnection();
		List<UserEntity> dtos = new LinkedList<UserEntity>();
		try {
			String query = "Select * from user";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserEntity userDto = new UserEntity();
				userDto.setId(resultSet.getLong("id"));
				userDto.setUserName(resultSet.getString("username"));
				userDto.setFullName(resultSet.getString("fullname"));
				userDto.setRoleId(resultSet.getLong("id"));
				dtos.add(userDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public int update(UserEntity t) {
		StringBuilder sql = new StringBuilder("UPDATE user SET fullname = ?, username = ?,");
		sql.append(" password = ?, roleid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		Connection connection = MysqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, t.getFullName());
			statement.setString(2, t.getUserName());
			statement.setString(3, t.getPassword());
			statement.setLong(4, t.getRoleId());
			statement.setTimestamp(5, t.getCreatedDate());
			statement.setString(6, t.getCreatedBy());
			statement.setTimestamp(7, t.getModifiedDate());
			statement.setString(8, t.getModifiedBy());
			statement.setLong(9, t.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	@Override
	public int insert(UserEntity t) {
		StringBuilder sql = new StringBuilder("INSERT INTO user (fullname, username,");
		sql.append(" password,  roleid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?)");
		Connection connection = MysqlConnection.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, t.getFullName());
			statement.setString(2, t.getUserName());
			statement.setString(3, t.getPassword());
			statement.setLong(4, t.getRoleId());
			statement.setTimestamp(5, t.getCreatedDate());
			statement.setString(6, t.getCreatedBy());

			return statement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void delete(long id) {
		Connection connection = MysqlConnection.getConnection();
		String query = "delete from user where id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public UserEntity findById(long id) {
		Connection connection = MysqlConnection.getConnection();
		UserEntity userEntity = new UserEntity();
		try {

			String query = "Select * from user where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userEntity.setId(resultSet.getLong("id"));
				userEntity.setFullName(resultSet.getString("fullname"));
				userEntity.setUserName(resultSet.getString("username"));
				userEntity.setPassword(resultSet.getString("password"));
				userEntity.setRoleId(resultSet.getLong("roleid"));
				userEntity.setCreatedDate(resultSet.getTimestamp("createddate"));
				userEntity.setCreatedBy(resultSet.getString("createdby"));
				userEntity.setCreatedBy(resultSet.getString("mo"));
				userEntity.setModifiedBy(resultSet.getString("modifiedby"));
				userEntity.setModifiedDate(resultSet.getTimestamp("modifieddate"));
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userEntity;
	}

	@Override
	public List<UserDto> findAllUser() {
		Connection connection = MysqlConnection.getConnection();
		List<UserDto> dtos = new LinkedList<UserDto>();
		try {
			String query = "Select u.id,u.username, u.fullname, r.name from user u join role r on u.roleid = r.id ";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserDto userDto = new UserDto();
				userDto.setId(resultSet.getLong("id"));
				userDto.setUserName(resultSet.getString("username"));
				userDto.setFullName(resultSet.getString("fullname"));
				userDto.setRoleName(resultSet.getString("name"));
				dtos.add(userDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public List<RoleEntity> findAllRole() {
		Connection connection = MysqlConnection.getConnection();
		String query = "select * from role";
		List<RoleEntity> roles = new LinkedList<RoleEntity>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				RoleEntity roleEntity = new RoleEntity();
				roleEntity.setId(resultSet.getLong("id"));
				roleEntity.setName(resultSet.getString("name"));
				roleEntity.setCode(resultSet.getString("code"));
				roles.add(roleEntity);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return roles;
	}

	@Override
	public UserEntity findByUsername(String username) {
		UserEntity userEntity = new UserEntity();
		try {
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("Select * from user where username =?");
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				userEntity.setId(resultSet.getLong("id"));
				userEntity.setUserName(resultSet.getString("username"));
				userEntity.setPassword(resultSet.getString("password"));
				userEntity.setRoleId(resultSet.getLong("roleid"));
				userEntity.setFullName(resultSet.getString("fullname"));
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userEntity;
	}

	@Override
	public RoleEntity findByRoleId(long id) {
		RoleEntity roleEntity = new RoleEntity();
		try {
			Connection connection = MysqlConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement("Select * from role where id =?");
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				roleEntity.setId(resultSet.getLong("id"));
				roleEntity.setName(resultSet.getString("name"));
				roleEntity.setCode(resultSet.getString("code"));

				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return roleEntity;
	}
}
