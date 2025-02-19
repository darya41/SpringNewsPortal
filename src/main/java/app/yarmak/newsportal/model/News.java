package app.yarmak.newsportal.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "news") // Corrected table name to "news"
public class News implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Id")
  private int id;

  @Column(name = "title")
  private String title;

  @Column(name = "brief")
  private String brief;

  @Column(name = "content")
  private String content;

  @Column(name = "author")
  private String author;

  @Column(name = "publicationDate")
  private Timestamp publicationDate;

  @Column(name = "views")
  private int views;

  @Column(name = "priority")
  private int priority;

  @Column(name = "statusNews")
  private String status;

  @Column(name = "idCategory") // Added idCategory field
  private int idCategory;

  public News() {}

  public News(
      int id,
      String title,
      String brief,
      String content,
      String author,
      Timestamp publicationDate,
      int views,
      int priority,
      String status,
      int idCategory) {  // Added idCategory to the constructor
    super();
    this.id = id;
    this.title = title;
    this.brief = brief;
    this.content = content;
    this.author = author;
    this.publicationDate = publicationDate;
    this.views = views;
    this.priority = priority;
    this.status = status;
    this.idCategory = idCategory;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrief() {
    return brief;
  }

  public void setBrief(String brief) {
    this.brief = brief;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Timestamp getPublicationDate() {
    return publicationDate;
  }
}