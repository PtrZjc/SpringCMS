package pl.zajacp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String name;// (max 100 znaków)
    @Column(nullable = true)
    private String description; // (może przyjmować wartość null)

    @ManyToMany
    @JoinTable(name = "category_article",
            joinColumns = @JoinColumn(name =
                    "article_id"),
            inverseJoinColumns = @JoinColumn(name =
                    "category_id"))
    private List<Article> articles;

    public Category() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void addArticle(Article article) {
        articles.add(article);
        article.getCategories().add(this);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}