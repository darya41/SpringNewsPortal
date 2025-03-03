package app.yarmak.newsportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.yarmak.newsportal.model.News;
import app.yarmak.newsportal.service.NewsService;
import app.yarmak.newsportal.service.ServiceException;
import app.yarmak.newsportal.dao.*;

@Service
public class NewsServiceImpl implements NewsService{
	
	private final NewsDao newsDao;
	
	 @Autowired
	 public NewsServiceImpl(NewsDao newsDao) {
		 this.newsDao = newsDao;
	 }
	 
	 @Transactional
	 @Override
	 public List<News> getAllNews() {
		try {
			return newsDao.getAllNews();
		}catch (DAOException e) {
			 throw new ServiceException("Ошибка при получении списка новостей", e);
		}
	 }

	 @Transactional
	 @Override
	 public News getNewsById(int id) {
		try {
			return newsDao.getNewsById(id);
		}catch (DAOException e) {
			throw new ServiceException("Ошибка при получении новости с ID: " + id, e);
		}		
	 }

	 @Transactional
	 @Override
	 public void addNews(News news) {
		try {
			newsDao.addNews(news);
		}catch (DAOException e) {
			 throw new ServiceException("Ошибка при добавлении новости", e);
		}		
	 }

	 @Transactional
	 @Override
	 public void updateNews(News news) {
		try {
			newsDao.updateNews(news);
		}catch (DAOException e) {
			throw new ServiceException("Ошибка при обновлении новости с ID: " + news.getId(), e);
		}		
	 }

	 @Transactional
	 @Override
	 public void deleteNews(int id) {
		try {
			newsDao.deleteNews(id);
		}catch (DAOException e) {
			 throw new ServiceException("Ошибка при удалении новости с ID: " + id, e);
		}	
	 }
}