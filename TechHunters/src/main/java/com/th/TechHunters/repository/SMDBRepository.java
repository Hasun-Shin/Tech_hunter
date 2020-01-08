package com.th.TechHunters.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.th.TechHunters.model.Scrap;

@Repository
public interface SMDBRepository extends MongoRepository<Scrap, String> {

	//void delete(List<String> Scrap);
	

	
	
}




