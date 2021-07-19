package com.myclass.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.myclass.entity.CategoryEntity;
import com.myclass.repository.CategoryRepository;
import com.myclass.repository.impl.CategoryRepositoryImpl;
import com.myclass.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository = null;

	public CategoryServiceImpl() {
		// TODO Auto-generated constructor stub
		categoryRepository = new CategoryRepositoryImpl();
	}

	@Override
	public List<CategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public int save(CategoryEntity categoryEntity) {
		categoryEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		return categoryRepository.insert(categoryEntity);
	}

	@Override
	public CategoryEntity findById(long id) {

		return categoryRepository.findById(id);
	}

	@Override
	public int update(CategoryEntity categoryEdit) {

		return categoryRepository.update(categoryEdit);
	}

	@Override
	public void delete(long idDelete) {
		categoryRepository.delete(idDelete);

	}

}
