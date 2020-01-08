package com.th.TechHunters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.th.TechHunters.model.BigdataNews;
import com.th.TechHunters.repository.BigdatanewsMongoDBRepository;

@Service
public class NewsService2 {
	
	@Autowired
	private BigdatanewsMongoDBRepository BigdatanewsMongoDBRepository;

	public List<BigdataNews> getPreviewAndTitleAndLink(String preview, String title, String link) {
		return BigdatanewsMongoDBRepository.findByPreviewAndTitleAndLink(preview, title, link);
	}

	public List<BigdataNews> getList() {
		return BigdatanewsMongoDBRepository.findAll();
	}
	
}
