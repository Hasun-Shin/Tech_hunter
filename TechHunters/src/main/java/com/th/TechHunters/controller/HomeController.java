package com.th.TechHunters.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping({ "/", "/home" })
	public String index() {
		return "index";
	}
@Controller
public class FeatureController {
	@GetMapping({ "/feature" })
	public String feature() {
			return "feature";
		}
}

}