package com.urunov.wrap.provider;

import com.urunov.wrap.vo.Website;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: apple
 * @created on 31/08/2020
 * @Project is wrap
 */
@Component
public class GraphQLDataFetcher{

    private final String REST_URL = "http://localhost:8080/website";

    @Autowired
    private RestTemplate restTemplate;

    public DataFetcher<List<Website>> getWebsiteList(){
        return dataFetchingEnvironment -> {
            return restTemplate
                    .exchange(REST_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Website>>() {
                    }).getBody();
        };
    }

    public DataFetcher<Website> getWebsiteById() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");

            return restTemplate.getForObject(REST_URL + "/" + id, Website.class);
        };
    }

    public DataFetcher<String> addWebsite() {
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            String url = dataFetchingEnvironment.getArgument("url");

            Website website = new Website();
            website.setName(name);
            website.setUrl(url);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Website> entity = new HttpEntity<>(website, headers);

            return restTemplate.postForObject(REST_URL, entity, String.class);
        };
    }

    public DataFetcher<String> updateWebsite() {

        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            String name = dataFetchingEnvironment.getArgument("name");
            String url = dataFetchingEnvironment.getArgument("url");

            Website website = new Website(Integer.parseInt(id), name, url);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Website> entity = new HttpEntity<>(website, headers);

            return restTemplate.exchange(REST_URL, HttpMethod.PUT, entity, new ParameterizedTypeReference<String>() {
            }).getBody();

        };
    }

    public DataFetcher<String> deleteWebsite() {

        return dataFetchingEnvironment -> {

            String id = dataFetchingEnvironment.getArgument("id");

            Website website = new Website();
            website.setId(Integer.parseInt(id));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Website> entity = new HttpEntity<>(website, headers);

            return restTemplate.exchange(REST_URL, HttpMethod.DELETE, entity, new ParameterizedTypeReference<String>() {
            }).getBody();
        };
    }
}

