package spring.mysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mysql.entity.Language;
import spring.mysql.entity.Project;
import spring.mysql.entity.User;
import spring.mysql.exception.ProjectException;
import spring.mysql.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private UserService userService;

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project getById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (!project.isPresent()) {
            throw new ProjectException(404, "Project with id " + id + " cannot be found");
        }
        return project.get();
    }

    public Project create(String title, String description, Long languageId, Long userId) {
        Language language = languageService.getById(languageId);
        User user = userService.getById(userId);
        Project project = Project.create(title, description, language, user);
        return projectRepository.save(project);
    }

    public Project update(Long id, String title, String description, Long languageId, Long userId) {
        Project project = projectRepository.getOne(id);
        Language language = null;
        User user = null;


        if (title != null)
            project.getTitle(title);


        return projectRepository.save(project);
    }

    public boolean delete(Long id) {
        Project project = getById(id);
        projectRepository.delete(project);
        return true;
    }

//
}
