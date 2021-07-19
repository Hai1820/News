package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.myclass.dbconnection.MysqlConnection;
import com.myclass.entity.CategoryEntity;
import com.myclass.repository.CategoryRepository;

public class CategoryRepositoryImpl implements CategoryRepository {

	@Override
	public List<CategoryEntity> findAll() {
		Connection connection = MysqlConnection.getConnection();
		List<CategoryEntity> categories = new LinkedList<CategoryEntity>();
		try {
			String query = "select * from category";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CategoryEntity categoryEntity = new CategoryEntity();
				categoryEntity.setId(resultSet.getLong("id"));
				categoryEntity.setName(resultSet.getString("name"));
				categoryEntity.setCode(resultSet.getString("code"));

				categories.add(categoryEntity);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public int update(CategoryEntity categoryEntity) {
		StringBuilder sql = new StringBuilder("UPDATE category SET name = ?, code = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		Connection connection = MysqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, categoryEntity.getName());
			statement.setString(2, categoryEntity.getCode());
			statement.setTimestamp(3, categoryEntity.getCreatedDate());
			statement.setString(4, categoryEntity.getCreatedBy());
			statement.setTimestamp(5, categoryEntity.getModifiedDate());
			statement.setString(6, categoryEntity.getModifiedBy());
			statement.setLong(7, categoryEntity.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	@Override
	public int insert(CategoryEntity categoryEntity) {
		StringBuilder sql = new StringBuilder("INSERT INTO category (name, code,");
		sql.append(" createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?)");
		Connection connection = MysqlConnection.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, categoryEntity.getName());
			statement.setString(2, categoryEntity.getCode());
			statement.setTimestamp(3, categoryEntity.getCreatedDate());
			statement.setString(4, categoryEntity.getCreatedBy());
			return statement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void delete(long id) {
		String query = "delete from category where id =?";
		Connection connection = MysqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public CategoryEntity findById(long id) {
		Connection connection = MysqlConnection.getConnection();
		CategoryEntity categoryEntity = new CategoryEntity();
		try {

			String query = "Select * from category where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				categoryEntity.setId(resultSet.getLong("id"));
				categoryEntity.setName(resultSet.getString("name"));
				categoryEntity.setCode(resultSet.getString("code"));
				categoryEntity.setCreatedDate(resultSet.getTimestamp("createddate"));
				categoryEntity.setCreatedBy(resultSet.getString("createdby"));
				break;

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return categoryEntity;
	}
}
