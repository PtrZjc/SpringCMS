package pl.zajacp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    private String title; //(max. 200 znaków),
    private String content; //
    private LocalDateTime created; //(wartość ma być automatycznie dodawana podczas zapisu)
    private LocalDateTime updated; //(wartość ma być automatycznie zmieniana podczas edycji).

    @OneToOne
    private Author author;

    @ManyToOne
    private Category category;

    public Article() {
    }

    public Article(String title, String content, LocalDateTime created, LocalDateTime updated, Author author) {
        this.title = title;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
