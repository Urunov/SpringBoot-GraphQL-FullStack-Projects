package book.project.resolver;

import book.project.model.Book;
import book.project.repository.BookRespository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: apple
 * @created on 13/08/2020
 * @Project is SpringGraphBook
 */
@Component
public class BookResolver implements GraphQLQueryResolver {

    @Autowired
    private final BookRespository bookRepository;

    public BookResolver(BookRespository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(String isbn){

        return new Book("Learn GraphQL Perfectly, ",  "9302333232");
    }

    public Connection<Book> books(int first, String after, DataFetchingEnvironment env) {
        List<Book> books = bookRepository.findAll();
        return new SimpleListConnection<>(books).get(env);
    }
        public Book getBook(){
        return new Book();
    }
}
