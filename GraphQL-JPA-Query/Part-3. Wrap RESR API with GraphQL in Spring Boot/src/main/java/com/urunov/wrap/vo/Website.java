package com.urunov.wrap.vo;

/**
 * @Author: apple
 * @created on 31/08/2020
 * @Project is wrap
 */
public class Website {

    private Integer id;
    private String name;

    private String url;

    public Website(){

    }

    public Website(Integer id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
