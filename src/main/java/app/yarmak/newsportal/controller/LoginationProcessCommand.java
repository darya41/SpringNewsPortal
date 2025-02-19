package app.yarmak.newsportal.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import app.yarmak.newsportal.model.News;
import app.yarmak.newsportal.model.RegistrationForm;
import app.yarmak.newsportal.service.*;
import app.yarmak.newsportal.service.impl.NewsServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginationProcessCommand {
	
	 NewsService newsService = new NewsServiceImpl();
	
	@RequestMapping("/showMainPage")
	public String showMainPage(Model model) {
		System.out.println("--------------------------S1");
		 List<News> allNews = newsService.getAllNews();
			System.out.println("--------------------------S2");
		 model.addAttribute("newsList", allNews);
			System.out.println("--------------------------S3");
		return "main-page";
	}

	@RequestMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		
		model.addAttribute("registrationForm", new RegistrationForm());

		// Дополнительные данные для dropbox и radio buttons
		model.addAttribute("countries", List.of("USA", "Canada", "Germany", "India"));
		model.addAttribute("genders", List.of("Male", "Female", "Other"));
		model.addAttribute("hobbiesList", List.of("Reading", "Traveling", "Sports", "Music"));
		return "register";
	}

	@RequestMapping("/processForm")
	public String processRegistration(@ModelAttribute("registrationForm") RegistrationForm form, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "register";
		}

		// Обработка данных (например, сохранение в БД)
		System.out.println("Registered user: " + form.getUsername());

		return "main-page";
	}

	@RequestMapping("/about")
	public String goToAboutPage() {
		return "about";
	}

}
