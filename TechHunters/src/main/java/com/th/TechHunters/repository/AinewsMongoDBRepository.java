package com.th.TechHunters.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.th.TechHunters.model.AiNews;

@Repository
public interface AinewsMongoDBRepository extends MongoRepository<AiNews, Long> {
	
	public List<AiNews> findByPreviewAndTitleAndLink(String preview, String title, String link);
	
//	List<News> findByImg(String img);
//	List<News> findByTitle(String title);
//	List<News> findByLink(String link);
}




