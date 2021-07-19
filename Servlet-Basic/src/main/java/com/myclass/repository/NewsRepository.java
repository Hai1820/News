package com.myclass.repository;

import java.util.List;

import com.myclass.dto.NewsDto;
import com.myclass.entity.NewEntity;

public interface NewsRepository extends GenericRepository<NewEntity>  {
	List<NewsDto> getAllByJoin();
	
}
