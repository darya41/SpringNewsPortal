package app.yarmak.newsportal.service.impl;

import java.util.List;

import app.yarmak.newsportal.model.News;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.dao.*;
import app.yarmak.newsportal.dao.impl.NewsDaoImpl;

public class NewsServiceImpl implements NewsService{
	
	private final NewsDao newsDao = new NewsDaoImpl();

	@Override
	public List<News> getAllNews() {
		System.out.println("--------------------------Service1");
		return newsDao.getAllNews();
	}

	@Override
	public News getNewsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNews(News news) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNews(News news) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNews(Long id) {
		// TODO Auto-generated method stub
		
	}

}
