package spring.graphql.project.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import spring.graphql.project.model.Author;
import spring.graphql.project.model.Book;
import spring.graphql.project.repository.AuthorRepository;
import spring.graphql.project.repository.BookRepository;

/**
 * @Author: apple
 * @created on 19/07/2020
 * @Project is SpringGraphql
 */
public class Query implements GraphQLQueryResolver {


        private BookRepository bookRepository;
        private AuthorRepository authorRepository;

        public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
            this.authorRepository = authorRepository;
            this.bookRepository = bookRepository;
        }

        public Iterable<Book> findAllBooks() {
            return bookRepository.findAll();
        }

        public Iterable<Author> findAllAuthors() {
            return authorRepository.findAll();
        }

        public long countBooks() {
            return bookRepository.count();
        }
        public long countAuthors() {
            return authorRepository.count();
        }
}
