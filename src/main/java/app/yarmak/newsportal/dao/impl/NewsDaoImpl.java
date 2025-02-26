package app.yarmak.newsportal.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import app.yarmak.newsportal.dao.NewsDao;
import app.yarmak.newsportal.model.News;

@Repository
public class NewsDaoImpl implements NewsDao {
	
	private final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	@Override
	public List<News> getAllNews() {
		try (Session session = factory.openSession()) {
            return session.createQuery("from News", News.class).getResultList(); 
        } catch (Exception e) {   
        	
            return null; 
        }
	}

	@Override
	public News getNewsById(int id) {
		try (Session session = factory.openSession()) {
            return session.get(News.class,id); 
        } catch (Exception e) {   
        	
            return null; 
        }
	}

	@Override
	public void addNews(News news) {
		try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(news);
            session.getTransaction().commit();
        } catch (Exception e) {
            
        }
		
	}

	@Override
	public void updateNews(News news) {
	   
	    try (Session session = factory.openSession()) {
	    	session.merge(news);
	    } catch (Exception e) {
	    }
	}



	@Override
	public void deleteNews(int id) {
		try (Session session = factory.openSession()) {
            session.beginTransaction();
            News news = session.get(News.class, id);
            if (news != null) {
                session.remove(news);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
        }
		
	}

}
