package book.project.resolver;

import book.project.model.Author;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 14/08/2020
 * @Project is SpringGraphBook
 */
@Component
public class AuthorResolver implements GraphQLQueryResolver {



    public Author getAuthor() {
         return new Author();
    }
}
