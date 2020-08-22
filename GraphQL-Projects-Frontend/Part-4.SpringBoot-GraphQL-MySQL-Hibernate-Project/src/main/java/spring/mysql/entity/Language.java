//package spring.mysql.entity;
//
//import javax.persistence.*;
//
///**
// * @Author: apple
// * @created on 21/08/2020
// * @Project is SpringGraphQLMySQL
// */
//
//
//@Entity
//@Table(name = "language")
//public class Language {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String code;
//    private String color;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "languageType")
//    private LanguageType languageType;
//
//    public Language() {
//    }
//
//    public static Language create(String name, String code, String color, String languageType) {
//        Language language = new Language();
//
//        language.setName(name);
//        language.setCode(code);
//        language.setColor(color);
//        language.setLanguageType(languageType);
//
//        return language;
//    }
//
//    public Language updateFields(String name, String code, String color, String languageType) {
//        if(name !=null) setName(name);
//        if(code!=null) setCode(code);
//        if(color!=null) setColor(color);
//        if(languageType!=null) setLanguageType(languageType);
//
//        return this;
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//
//    public void setLanguageType(LanguageType languageType) {
//        this.languageType = languageType;
//    }
//
//    public void setLanguageType(String languageType) {
//        this.languageType = LanguageType.valueOf(languageType);
//    }
//
//    public enum LanguageType{
//        Programming, Data, Markup
//    }
//}
