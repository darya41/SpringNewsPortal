package app.yarmak.newsportal.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import app.yarmak.newsportal.dao.NewsDao;
import app.yarmak.newsportal.model.News;

public class NewsDaoImpl implements NewsDao {
	
	private final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	@Override
	public List<News> getAllNews() {
		System.out.println("--------------------------D1");
		try (Session session = factory.openSession()) {
			System.out.println("--------------------------");
            return session.createQuery("from News", News.class).getResultList(); 
        } catch (Exception e) {   
        	System.out.println("--------------------------ERROR");
        	e.printStackTrace();
            return null; 
        }
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
