package com.th.TechHunters.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.th.TechHunters.model.Scrap;
import com.th.TechHunters.repository.SMDBRepository;


@Service

public class ScrapService {
	
	@Autowired
	private SMDBRepository smdbRepository;

	public List<Scrap> getPreviewAndTitleAndLink(String preview, String title, String link) {
		return SMDBRepository.findByPreviewAndTitleAndLink(preview, title, link);
	}

	public List<Scrap> getList() {
		return SMDBRepository.findAll();
	}


	
	
	
}
