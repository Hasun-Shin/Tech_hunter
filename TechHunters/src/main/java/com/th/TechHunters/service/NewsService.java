package com.th.TechHunters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.th.TechHunters.model.AiNews;
import com.th.TechHunters.repository.AinewsMongoDBRepository;


@Service
public class NewsService {
	@Autowired
	private AinewsMongoDBRepository AinewsMongoDBRepository;

	public List<AiNews> getPreviewAndTitleAndLink(String preview, String title, String link) {
		return AinewsMongoDBRepository.findByPreviewAndTitleAndLink(preview, title, link);
	}

	public List<AiNews> getList() {
		return AinewsMongoDBRepository.findAll();
	}

	
}
