package pl.coderslab.book;

import lombok.*;
import pl.coderslab.author.Author;
import pl.coderslab.category.Category;
import pl.coderslab.publisher.Publisher;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table( name = "books")
@ToString(exclude = {"rating", "description", "authors", "category"})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4)
    private String title;
    @Min(1)
    @Max(10)
    private int rating;
    @Size(max = 600)
    private String description;
    @ManyToOne
    @NotNull
    private Publisher publisher;
    @ManyToMany()
    @NotNull
    private List<Author> authors;
    @Min(1)
    private int pages;
    @ManyToOne
    private Category category;
}
