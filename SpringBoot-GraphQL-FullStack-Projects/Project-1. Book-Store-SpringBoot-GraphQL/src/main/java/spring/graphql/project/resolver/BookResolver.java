package spring.graphql.project.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import spring.graphql.project.model.Author;
import spring.graphql.project.model.Book;
import spring.graphql.project.repository.AuthorRepository;

/**
 * @Author: apple
 * @created on 19/07/2020
 * @Project is SpringGraphql
 */
public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findOne(book.getAuthor().getId());
    }
}
