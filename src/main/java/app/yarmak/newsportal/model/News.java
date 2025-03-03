package app.yarmak.newsportal.model;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news") // Corrected table name to "news"
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Поле id пустое")
	@Column(name = "Id")
	private int id;

	@NotEmpty(message = "Поле название не заполнено")
	@Size(max = 255, message = "Название не должно превышать 255 символов")
	@Column(name = "title")
	private String title;

	@NotEmpty(message = "Поле краткое описание не заполнено")
	@Size(max = 500, message = "Краткое описание не должно превышать 500 символов")
	@Column(name = "brief")
	private String brief;

  
	@NotEmpty(message = "Поле содержание не заполнено")
	@Size(max = 2000, message = "Содержание не должно превышать 2000 символов")
	@Column(name = "content")
	private String content;

	@NotEmpty(message = "Поле автор не заполнено")
	@Size(max = 100, message = "Автор не должен превышать 100 символов")
	@Column(name = "author")
	private String author;

	@Column(name = "publicationDate")
	private Timestamp publicationDate;

	@NotNull(message = "Просмотры не могут быть меньше 0 или вообще их не быть")
	@Column(name = "views")
	private int views;

	@NotNull
	@Min(value = 0, message = "Приоритет не должен быть меньше 0")
	@Max(value = 10, message="Приоритет не должен быть больше 10") 
	@Column(name = "priority")
	private int priority;

	@NotEmpty(message = "Поле статус не заполнено")
	@Size(max = 45, message = "Статус не должен превышать 45 символов")
	@Column(name = "statusNews")
	private String status;

	@NotNull(message = "Категория не выбрана")
	@Column(name = "idCategory")
	private int idCategory;
}