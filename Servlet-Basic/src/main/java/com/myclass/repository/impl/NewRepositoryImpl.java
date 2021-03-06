package com.myclass.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.myclass.dbconnection.MysqlConnection;
import com.myclass.dto.NewsDto;
import com.myclass.entity.NewEntity;
import com.myclass.repository.NewsRepository;

public class NewRepositoryImpl implements NewsRepository {

	@Override
	public List<NewsDto> getAllByJoin() {
		Connection connection = MysqlConnection.getConnection();
		List<NewsDto> dtos = new LinkedList<NewsDto>();
		try {
			String query = "Select n.id, n.title, n.shortdescription, c.name from news n join category c on n.categoryid = c.id ";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				NewsDto newsDto = new NewsDto();
				newsDto.setId(resultSet.getLong("id"));
				newsDto.setTitle(resultSet.getString("title"));
				newsDto.setShortDescription(resultSet.getString("shortdescription"));
				newsDto.setCategoryName(resultSet.getString("name"));
				dtos.add(newsDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}

	@Override
	public List<NewEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(NewEntity newEntity) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?");
		Connection connection = MysqlConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, newEntity.getTitle());
			statement.setString(2, newEntity.getContent());
			statement.setString(3, newEntity.getThumbnail());
			statement.setString(4, newEntity.getShortDescription());
			statement.setLong(5, newEntity.getCategoryId());
			statement.setTimestamp(6, newEntity.getCreatedDate());
			statement.setString(7, newEntity.getCreatedBy());
			statement.setTimestamp(8, newEntity.getModifiedDate());
			statement.setString(9, newEntity.getModifiedBy());
			statement.setLong(10, newEntity.getId());
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	@Override
	public int insert(NewEntity newEntity) {
		StringBuilder sql = new StringBuilder("INSERT INTO news (title, content,");
		sql.append(" thumbnail, shortdescription, categoryid, createddate, createdby)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
		Connection connection = MysqlConnection.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(sql.toString());
			statement.setString(1, newEntity.getTitle());
			statement.setString(2, newEntity.getContent());
			statement.setString(3, newEntity.getThumbnail());
			statement.setString(4, newEntity.getShortDescription());
			statement.setLong(5, newEntity.getCategoryId());
			statement.setTimestamp(6, newEntity.getCreatedDate());
			statement.setString(7, newEntity.getCreatedBy());

			return statement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public void delete(long id) {
		String query = "delete from news where id =?";
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
	public NewEntity findById(long id) {
		Connection connection = MysqlConnection.getConnection();
		NewEntity newEntity = new NewEntity();
		try {

			String query = "Select * from news where id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				newEntity.setId(resultSet.getLong("id"));
				newEntity.setTitle(resultSet.getString("title"));
				newEntity.setContent(resultSet.getString("content"));
				newEntity.setThumbnail(resultSet.getString("thumbnail"));
				newEntity.setShortDescription(resultSet.getString("shortdescription"));
				newEntity.setCategoryId(resultSet.getLong("categoryid"));
				newEntity.setCreatedDate(resultSet.getTimestamp("createddate"));
				newEntity.setCreatedBy(resultSet.getString("createdby"));
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return newEntity;
	}


}
