package book.project.repository;

import book.project.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 14/08/2020
 * @Project is SpringGraphBook
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
