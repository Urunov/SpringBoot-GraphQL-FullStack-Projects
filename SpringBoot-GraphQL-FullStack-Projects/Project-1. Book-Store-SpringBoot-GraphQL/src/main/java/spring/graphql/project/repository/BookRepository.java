package spring.graphql.project.repository;

import org.springframework.data.repository.CrudRepository;
import spring.graphql.project.model.Book;

/**
 * @Author: apple
 * @created on 19/07/2020
 * @Project is SpringGraphql
 */


public interface BookRepository extends CrudRepository<Book, Long> {
    Book findOne(Long id);
}
