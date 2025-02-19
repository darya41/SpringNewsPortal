package app.yarmak.newsportal.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.yarmak.newsportal.model.News;
import app.yarmak.newsportal.service.*;
import app.yarmak.newsportal.service.impl.NewsServiceImpl;

@Controller
@RequestMapping("/login")
public class ProcessCommand {
	
	 NewsService newsService = new NewsServiceImpl();
	
	@RequestMapping("/showMainPage")
	public String showMainPage(Model model) {
		
		 List<News> allNews = newsService.getAllNews();
		 
		 model.addAttribute("newsList", allNews);
		return "main-page";
	}

	@RequestMapping("/add")
	public String addNews() {

		return "addNews";
	}

}
