package spring.mysql.entity;

import javax.persistence.*;
import java.lang.annotation.Target;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

//    @ManyToOne
//    @JoinColumn(name = "language_id", referencedColumnName = "id")
//    private Language language;
//
//
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;

    public Project() {
    }

//    public static Project create(String title, String description, Language language, User user) {
//        Project project = new Project();
//        project.setTitle(title);
//        project.setDescription(description);
//        project.setUser(user);
//        project.setLanguage(language);
//        return project;
//    }
//
//    public Project updateFields(String title, String description, Language language, User user){
//        if(title != null) {
//            setTitle(title);
//        }
//        if (description !=null){
//            setDescription(description);
//        }
//        if(language!=null){
//            setLanguage(language);
//        }
//        if(user !=null){
//            setUser(user);
//        }
//
//        return this;
//    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Language getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(Language language) {
//        this.language = language;
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
