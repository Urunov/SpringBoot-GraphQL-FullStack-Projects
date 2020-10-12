package spring.mysql.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String color;

    @Enumerated(EnumType.STRING)
    private LanguageType languageType;



    public static Language create(String name, String code, String color, String languageType) {
        Language language = new Language();

        language.setName(name);
        language.setCode(code);
        language.setColor(color);
        //language.setLanguageType(languageType);

        return language;
    }

    public Language updateFields(String name, String code, String color, String languageType) {
        if(name !=null) setName(name);
        if(code!=null) setCode(code);
        if(color!=null) setColor(color);
       // if(languageType!=null) setLanguageType(languageType);

        return this;
    }




    public enum LanguageType{
        Programming, Data, Markup
    }
}
