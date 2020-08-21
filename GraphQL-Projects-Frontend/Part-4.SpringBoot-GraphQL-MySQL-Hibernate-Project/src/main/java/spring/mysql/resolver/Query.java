package spring.mysql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.mysql.entity.Language;
import spring.mysql.entity.Project;
import spring.mysql.entity.User;
import spring.mysql.service.LanguageService;
import spring.mysql.service.ProjectService;
import spring.mysql.service.UserService;

import java.util.List;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */
@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private LanguageService languageService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;

    // Language

    public List<Language> allLanguages() {
        return languageService.getAll();
    }

    public Language language(Long id) {
        return languageService.getById(id);
    }

    public List<Language> languageType(String languageType) {
        return languageService.getByLanguageType(languageType);
    }

    // User

    public List<User> allUsers() {
        return userService.getAll();
    }

    public User user(Long id) {
        return userService.getById(id);
    }

    // Project

    public List<Project> allProjects() {
        return projectService.getAll();
    }

    public Project project(Long id) {
        return projectService.getById(id);
    }

    public List<Project> userProjects(Long userId) {
        return projectService.getUserProjects(userId);
    }
}