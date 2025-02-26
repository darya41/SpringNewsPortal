package app.yarmak.newsportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.yarmak.newsportal.model.News;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.dao.*;

@Component
@Service
public class NewsServiceImpl implements NewsService{
	
	private final NewsDao newsDao;
	
	 @Autowired
	 public NewsServiceImpl(NewsDao newsDao) {
		 this.newsDao = newsDao;
	 }

	@Override
	public List<News> getAllNews() {
		return newsDao.getAllNews();
	}

	@Override
	public News getNewsById(int id) {
		return newsDao.getNewsById(id);
		
	}

	@Override
	public void addNews(News news) {
		 newsDao.addNews(news);
		
	}

	@Override
	public void updateNews(News news) {
		newsDao.updateNews(news);
		
	}

	@Override
	public void deleteNews(int id) {
		newsDao.deleteNews(id);
		
	}

}
