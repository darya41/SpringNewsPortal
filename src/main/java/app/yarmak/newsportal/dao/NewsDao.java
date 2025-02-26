package app.yarmak.newsportal.dao;

import java.util.List;

import app.yarmak.newsportal.model.News;

public interface NewsDao {
	List<News> getAllNews();

    News getNewsById(int id);

    void addNews(News news);

    void updateNews(News news);

    void deleteNews(int id);

}
