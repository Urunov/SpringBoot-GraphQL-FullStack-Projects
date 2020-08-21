package spring.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.mysql.entity.Language;

import java.util.List;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */
public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Query("select l from Language l where l.languageType = upper(:languageType)")
    List<Language> findByLanguageType(@Param("languageType") String languageType);
}
