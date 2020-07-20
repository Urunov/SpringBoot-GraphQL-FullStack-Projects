package spring.graphql.project.repository;

import org.springframework.data.repository.CrudRepository;
import spring.graphql.project.model.Author;

/**
 * @Author: apple
 * @created on 19/07/2020
 * @Project is SpringGraphql
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {
    Author findOne(Long id);
}
