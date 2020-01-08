package com.th.TechHunters.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.th.TechHunters.model.Conference;

@Repository
public interface ConferenceMongoDBRepository extends MongoRepository<Conference, Long> {
	
	public List<Conference> findByImgAndTitleAndLinkAndDateAndPlace(String img, String title, String link, String date, String place);

}




