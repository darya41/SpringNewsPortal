package app.yarmak.newsportal.controller;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.yarmak.newsportal.model.News;
import app.yarmak.newsportal.service.*;

@Controller
@Component
@RequestMapping("/login")
public class NewsController {
	
	private final NewsService newsService;
	
	@Autowired
	public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }
	
	@RequestMapping("/showMainPage")
	public String showMainPage(Model model) {
		
		 List<News> allNews = newsService.getAllNews();
		 
		 model.addAttribute("newsList", allNews);
		return "main-page";
	}

	@RequestMapping("/addPage")
	public String goToAddNewsPage(Model model) {
		model.addAttribute("news", new News());
		return "addNews";
	}
	
	@GetMapping("/editPage/{id}")
	public String goToEditNewsPage(@PathVariable("id") int id, Model model) {
		News news = newsService.getNewsById(id);
		model.addAttribute("news", news);
		return "editNews";
	}
	

	@GetMapping("/delete/{id}")
	public String deleteNews(@PathVariable("id") int id) {
		 newsService.deleteNews(id);
	     return "redirect:/login/showMainPage";
	}
	
	@GetMapping("/viewNews/{id}")
	public String viewNews(@PathVariable("id") int id,Model model) {
		News news = newsService.getNewsById(id);
		model.addAttribute("news", news);
		return "viewNews";
	}
	
	@PostMapping("/add")
	public String addNews(@ModelAttribute("news") News news) {	
	    news.setPublicationDate(new Timestamp(System.currentTimeMillis()));
		newsService.addNews(news);
		return "redirect:/login/showMainPage";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("news") News news) {
		newsService.updateNews(news);
		return "redirect:/login/showMainPage";
	}

}
