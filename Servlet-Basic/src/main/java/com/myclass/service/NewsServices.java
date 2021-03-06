package com.myclass.service;

import java.util.List;

import com.myclass.dto.NewsDto;
import com.myclass.entity.NewEntity;

public interface NewsServices {

	List<NewsDto> findAllByJoin();

	int save(NewEntity entity);

	int update(NewEntity entity);

	void delete(long id);

	List<NewEntity> findAll();

	NewEntity findOne(long id);

	List<NewEntity> findByCategoryId(Long categoryId);

}
