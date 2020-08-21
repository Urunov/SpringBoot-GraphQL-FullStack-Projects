package spring.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.mysql.entity.Project;

import java.util.List;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p from Project p where p.user.id = :userId")
    List<Project> findUserProjects(@Param("userId") Long userId);
}
