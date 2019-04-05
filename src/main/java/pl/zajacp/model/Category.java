package pl.zajacp.model;

import javax.persistence.*;
import java.math.BigDecimal;

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
    @ManyToOne
    private Article article;
}