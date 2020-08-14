package book.project.mutation;

import book.project.model.Author;
import book.project.model.AuthorWrapper;
import book.project.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author: apple
 * @created on 14/08/2020
 * @Project is SpringGraphBook
 */
@Component
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final AuthorRepository repository;

    @Autowired
    public AuthorMutationResolver(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author createAuthor(AuthorWrapper wrapper){
        Author author = new Author(wrapper.getName());

        author.setId(UUID.randomUUID().getLeastSignificantBits());

        return repository.save(new Author(wrapper.getName()));
    }
}
