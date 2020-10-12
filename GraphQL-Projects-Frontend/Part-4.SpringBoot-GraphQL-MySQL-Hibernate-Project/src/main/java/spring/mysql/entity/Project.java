package spring.mysql.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.annotation.Target;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
