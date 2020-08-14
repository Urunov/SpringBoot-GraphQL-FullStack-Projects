package book.project.model;

import java.time.LocalDate;

/**
 * @Author: apple
 * @created on 13/08/2020
 * @Project is SpringGraphBook
 */
public class BookWrapper {

    private String title;
    private String isbn;
    private LocalDate publishedDate;


    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
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
