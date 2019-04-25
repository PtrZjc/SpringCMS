package pl.zajacp.article;

import pl.zajacp.author.Author;
import pl.zajacp.category.Category;
import pl.zajacp.validation.DraftValidation;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;
import java.time.LocalDateTime;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 300)
    @NotNull(groups = {Default.class, DraftValidation.class})
    @Size(groups = {Default.class, DraftValidation.class}, max=300, min=4)
    private String title;

    @Column(length = 1000)
    @NotNull(groups = {Default.class, DraftValidation.class})
    @Size(max=1000, groups = {Default.class, DraftValidation.class})
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Boolean draft;

    @NotNull(groups = Default.class)
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @NotNull(groups = Default.class)
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Article() {
    }

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        author.getArticles().add(this);
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", author=" + author +
                ", category=" + category +
                '}';
    }
}