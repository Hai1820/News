package com.myclass.service;

import java.util.List;

import com.myclass.entity.CategoryEntity;

public interface CategoryService {
	List<CategoryEntity> findAll();

	int save(CategoryEntity categoryEntity);

	CategoryEntity findById(long id);

	int update(CategoryEntity categoryEdit);

	void delete(long idDelete);
}
