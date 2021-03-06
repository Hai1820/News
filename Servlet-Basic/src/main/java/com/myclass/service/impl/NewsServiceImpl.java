package com.myclass.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.myclass.dto.NewsDto;
import com.myclass.entity.NewEntity;
import com.myclass.repository.NewsRepository;
import com.myclass.repository.impl.NewRepositoryImpl;
import com.myclass.service.NewsServices;

public class NewsServiceImpl implements NewsServices {
	private NewsRepository newsRepository = null;

	public NewsServiceImpl() {
		newsRepository = new NewRepositoryImpl();
	}

	@Override
	public List<NewsDto> findAllByJoin() {

		return newsRepository.getAllByJoin();
	}

	@Override
	public int save(NewEntity entity) {
		entity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		return newsRepository.insert(entity);
	}

	@Override
	public int update(NewEntity entity) {
		return newsRepository.update(entity);
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
			newsRepository.delete(id);
	}

	@Override
	public List<NewEntity> findAll() {
		return newsRepository.findAll();
	}

	@Override
	public NewEntity findOne(long id) {
		NewEntity newEntity = newsRepository.findById(id);
		return newEntity;
	}

	@Override
	public List<NewEntity> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
