package book.project.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @Author: apple
 * @created on 13/08/2020
 * @Project is SpringGraphBook
 */
@Entity
public class Book {


    private String title;

    @Id
    private String isbn;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )

    private Set<Author> authors;

    public Book(Set<Author> authors) {
        this.authors = authors;
    }

    public Book(String title, String isbn, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
    }

    public Book(){

    }
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
