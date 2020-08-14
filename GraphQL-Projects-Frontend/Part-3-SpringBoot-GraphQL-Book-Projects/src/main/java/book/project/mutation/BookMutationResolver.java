package book.project.mutation;

import book.project.model.Author;
import book.project.model.Book;
import book.project.model.BookWrapper;
import book.project.repository.AuthorRepository;
import book.project.repository.BookRespository;
import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 13/08/2020
 * @Project is SpringGraphBook
 */
@Component
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookRespository bookRespository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookMutationResolver(BookRespository bookRespository, AuthorRepository authorRepository) {
        this.bookRespository = bookRespository;
        this.authorRepository = authorRepository;
    }


    public Book createBook(BookWrapper bookWrapper) {

        return bookRespository.save(new Book(bookWrapper.getTitle(), bookWrapper.getIsbn()));
    }

    public Book addAuthor(long authorId, String isbn) {

        Optional<Author> author = authorRepository.findById(authorId);
        Optional<Book> book = bookRespository.findById(isbn);

        if(author.isPresent() && book.isPresent()) {
            book.get().setAuthors(Collections.singletonMap(author.get()));
            bookRespository.save(book.get());
            return book.get();
        }
        throw new GraphQLException("could not add author");
    }
}
