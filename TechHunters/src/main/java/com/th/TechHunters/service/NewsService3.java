package com.th.TechHunters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.th.TechHunters.model.Conference;
import com.th.TechHunters.repository.ConferenceMongoDBRepository;

@Service
public class NewsService3 {
	
	@Autowired
	private ConferenceMongoDBRepository ConferenceMongoDBRepository;

	public List<Conference> getImgAndTitleAndLinkAndDateAndPlace(String img, String title, String link, String date, String place) {
		return ConferenceMongoDBRepository.findByImgAndTitleAndLinkAndDateAndPlace(img, title, link, date, place);
	}

	public List<Conference> getList() {
		return ConferenceMongoDBRepository.findAll();
	}
	
}
