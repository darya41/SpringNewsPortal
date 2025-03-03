package app.yarmak.newsportal.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import app.yarmak.newsportal.dao.DAOException;
import app.yarmak.newsportal.dao.NewsDao;
import app.yarmak.newsportal.model.News;

@Repository
public class NewsDaoImpl implements NewsDao {
	
	private final SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

	@Override
	public List<News> getAllNews() {
		try (Session session = factory.openSession()) {
            return session.createQuery("from News", News.class).getResultList(); 
        } catch (HibernateException e) {          	
        	 throw new DAOException("Ошибка при получении всех новостей", e);
        }
	}

	@Override
	public News getNewsById(int id) {
		try (Session session = factory.openSession()) {
            return session.get(News.class,id); 
        } catch (HibernateException e) {    	
        	 throw new DAOException("Ошибка при получении новости по ID", e);
        }
	}

	@Override
	public void addNews(News news) {
		try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(news);
            session.getTransaction().commit();
        } catch (HibernateException e) {
        	throw new DAOException("Ошибка при добавлении новости", e);
        }	
	}

	@Override
	public void updateNews(News news) {
	    Session currentSession = factory.getCurrentSession();
	    Transaction transaction = null;
	    try {
	        transaction = currentSession.beginTransaction();

	        News existingNews = currentSession.get(News.class, news.getId());
	        if (existingNews != null) {
	        	
	            existingNews.setTitle(news.getTitle());
	            existingNews.setAuthor(news.getAuthor());
	            existingNews.setBrief(news.getBrief());
	            existingNews.setContent(news.getContent());
	            existingNews.setPriority(news.getPriority());
	            existingNews.setStatus(news.getStatus());

	            currentSession.merge(existingNews);
	        } else {
	            throw new DAOException("Новость с ID " + news.getId() + " не найдена");
	        }

	        transaction.commit();
	    } catch (HibernateException e) {
	    	
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        throw new DAOException("Ошибка при обновлении новости с ID " + news.getId(), e);
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
        } catch (HibernateException e) {
        	 throw new DAOException("Ошибка при удалении новости", e);
        }		
	}
}