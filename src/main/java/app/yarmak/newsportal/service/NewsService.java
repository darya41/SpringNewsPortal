package app.yarmak.newsportal.service;

import java.util.List;

import app.yarmak.newsportal.model.News;

public interface NewsService {
	
	 List<News> getAllNews();

	 News getNewsById(Long id);

	 void addNews(News news);

	 void updateNews(News news);

	 void deleteNews(Long id);
}
