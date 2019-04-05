package pl.zajacp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="articles")
public class Article {

    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    private String title; //(max. 200 znaków),
    private String content; //
    private String created; //(wartość ma być automatycznie dodawana podczas zapisu)
    private String updated; //(wartość ma być automatycznie zmieniana podczas edycji).

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "article")
    private Author author;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "article")
    private List<Category> categories;

}
