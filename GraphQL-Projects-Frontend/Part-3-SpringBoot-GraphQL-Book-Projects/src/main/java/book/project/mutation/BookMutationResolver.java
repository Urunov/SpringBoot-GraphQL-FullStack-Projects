package book.project.mutation;

import book.project.model.Book;
import book.project.model.BookWrapper;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 13/08/2020
 * @Project is SpringGraphBook
 */
@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    public Book createBook(BookWrapper bookWrapper) {

        return new Book(bookWrapper.getTitle(), bookWrapper.getIsbn());
    }
}
