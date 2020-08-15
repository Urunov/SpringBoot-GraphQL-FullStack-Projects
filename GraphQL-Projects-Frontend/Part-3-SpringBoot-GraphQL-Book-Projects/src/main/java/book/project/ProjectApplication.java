package book.project;

import book.project.model.Author;
import book.project.model.Book;
import book.project.repository.AuthorRepository;
import book.project.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class ProjectApplication implements ApplicationRunner {

    @Autowired
    private BookRespository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {


   }
}
