package book.project.resolver;

import book.project.model.Author;
import book.project.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.relay.Connection;
import graphql.relay.SimpleListConnection;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: apple
 * @created on 14/08/2020
 * @Project is SpringGraphBook
 */
@Component
public class AuthorResolver implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;


    @Autowired
    public AuthorResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public Author getAuthor() {
         return new Author();
    }

    public Connection<Author> authors(int first, String after, DataFetchingEnvironment env) {
        List<Author> all = authorRepository.findAll();
        return new SimpleListConnection<>(all).get(env);
    }
}
