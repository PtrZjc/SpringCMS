package pl.zajacp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    @NotNull
    @Size(min = 5)
    private String name;// (max 100 znaków)
    @Column(nullable = true)
    private String description; // (może przyjmować wartość null)

    @ManyToMany
    @JoinTable(name = "category_article",
            joinColumns = @JoinColumn(name =
                    "article_id"),
            inverseJoinColumns = @JoinColumn(name =
                    "category_id"))
    private List<Article> articles = new ArrayList<>();

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

    public void setArticles(List<Article> articles) {
        this.articles = articles;
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