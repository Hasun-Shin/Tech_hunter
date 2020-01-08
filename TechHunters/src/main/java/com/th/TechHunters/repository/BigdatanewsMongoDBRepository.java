package com.th.TechHunters.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.th.TechHunters.model.BigdataNews;

@Repository
public interface BigdatanewsMongoDBRepository extends MongoRepository<BigdataNews, Long> {
	
	public List<BigdataNews> findByPreviewAndTitleAndLink(String preview, String title, String link);
	
}




