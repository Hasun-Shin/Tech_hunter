package com.th.TechHunters.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.th.TechHunters.model.AiNews;
import com.th.TechHunters.model.BigdataNews;
import com.th.TechHunters.model.Conference;
import com.th.TechHunters.model.Scrap;
import com.th.TechHunters.model.User;
import com.th.TechHunters.repository.AinewsMongoDBRepository;
import com.th.TechHunters.repository.BigdatanewsMongoDBRepository;
import com.th.TechHunters.repository.ConferenceMongoDBRepository;
import com.th.TechHunters.repository.SMDBRepository;
import com.th.TechHunters.service.NewsService;
import com.th.TechHunters.service.NewsService2;
import com.th.TechHunters.service.NewsService3;

@Controller
public class NewsControlller {
	
	@Autowired
	NewsService newsService;
	@Autowired
	NewsService2 newsService2;
	@Autowired
	NewsService3 newsService3;
	@Autowired
	private SMDBRepository smdbRepository;
	@Autowired
	private AinewsMongoDBRepository AinewsMongoDBRepository;
	@Autowired
	private BigdatanewsMongoDBRepository BigdatanewsMongoDBRepository;
	@Autowired
	private ConferenceMongoDBRepository ConferenceMongoDBRepository;
	@Autowired
	HttpSession session;

	@GetMapping({ "/ainews" })
	public String ainews() {
		return "ainews";
	}

	@PostMapping("/ainews")
	public String aiPost(@ModelAttribute AiNews news) {
		AiNews aidbnews = (AiNews) newsService.getPreviewAndTitleAndLink(news.getPreview(), news.getTitle(),
				news.getLink());
		if (aidbnews != null) {
			session.setAttribute("news_info", aidbnews);
			System.out.println(aidbnews);
		}
		return "ainews";
	}
	
	@GetMapping({ "/bigdatanews" })
	public String bigdatanews() {
		return "bigdatanews";
	}
	
	@PostMapping("/bigdatanews")
	public String bigdataPost(@ModelAttribute BigdataNews news) {
		BigdataNews bddbnews = (BigdataNews) newsService2.getPreviewAndTitleAndLink(news.getPreview(), news.getTitle(),
				news.getLink());
		if (bddbnews != null) {
			session.setAttribute("news_info", bddbnews);
			System.out.println(bddbnews);
		}
		return "bigdatanews";
	}
	
	@GetMapping({ "/conference" })
	public String conference() {
		return "conference";
	}
	
	@PostMapping("/conference")
	public String conferencePost(@ModelAttribute Conference news) {
		Conference codbnews = (Conference) newsService3.getImgAndTitleAndLinkAndDateAndPlace(news.getImg(), news.getTitle(),
				news.getLink(), news.getDate(), news.getPlace());
		if (codbnews != null) {
			session.setAttribute("news_info", codbnews);
			System.out.println(codbnews);
		}
		return "bigdatanews";
	}

	@GetMapping({ "/ailist" })
	@ResponseBody
	public List<AiNews> ailist() {
//		List<News> list = newsService.getList();
		List<AiNews> ailist = AinewsMongoDBRepository.findAll();
		return ailist;
	}
	
	@GetMapping({ "/bigdatalist" })
	@ResponseBody
	public List<BigdataNews> bigdatalist() {
//		List<News> list = newsService.getList();
		List<BigdataNews> bigdatalist = BigdatanewsMongoDBRepository.findAll();
		return bigdatalist;
	}
	
	@GetMapping({ "/conferencelist" })
	@ResponseBody
	public List<Conference> conferencelist() {
		List<Conference> conferencelist = ConferenceMongoDBRepository.findAll();
		return conferencelist;
	}
	
	@GetMapping({ "/test" })
	@ResponseBody
	public List<Scrap> testlist() {
		List<Scrap> testlist = smdbRepository.findAll();
		return testlist;
	}
	
	@PostMapping("/test")
	public String testPost(@ModelAttribute Scrap scrap, HttpSession session) {
		User user = (User) session.getAttribute("user_info");
		String email = user.getEmail();
		scrap.setEmail(email);
		smdbRepository.save(scrap);
		System.out.println(scrap);
		return "ok";
	}
	
	@DeleteMapping("/test")
	public String testDelete(@ModelAttribute Scrap scrap, HttpSession session) {
		
		smdbRepository.delete(scrap);
		System.out.println(scrap);
		return "ok";
		
		
	}
	
}