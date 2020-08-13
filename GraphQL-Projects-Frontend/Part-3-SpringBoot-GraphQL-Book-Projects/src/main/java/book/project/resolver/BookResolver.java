package book.project.resolver;

import book.project.model.Book;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 13/08/2020
 * @Project is SpringGraphBook
 */
@Component
public class BookResolver implements GraphQLQueryResolver {

    public Book getBook(String isbn){

        return new Book("Learn GraphQL Perfectly, ",  "9302333232");
    }

}
