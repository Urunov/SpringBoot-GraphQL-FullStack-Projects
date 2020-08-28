package com.urunov.books;

import com.introproventures.graphql.jpa.query.autoconfigure.GraphQLSchemaConfigurer;
import com.introproventures.graphql.jpa.query.autoconfigure.GraphQLShemaRegistration;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.jpa.AvailableSettings;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: apple
 * @created on 28/08/2020
 * @Project is GraphQL-JPA
 */

@Configuration
public class BookSchemaConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "books")
    @Qualifier("bookDataSource")
    public DataSource bookDataSource(){
        return DataSourceBuilder.create().build();
    }

    public LocalContainerEntityManagerFactoryBean  bookEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("bookDataSource") DataSource bookDataSource) {

        Map<String, Object> properties = new HashMap<>();

        properties.put(AvailableSettings.HBM2DDL_AUTO, "create-drop");
        properties.put(AvailableSettings.HBM2DDL_CREATE_SCHEMAS, "true");
        properties.put(AvailableSettings.DIALECT, H2Dialect.class.getName());
        properties.put(AvailableSettings.SHOW_SQL, "true");
        properties.put(AvailableSettings.FORMAT_SQL, "true");

        return builder
                .dataSource(bookDataSource)
                .packages(Book.class)
                .persistenceUnit("books")
                .properties(properties)
                .build();

       }

    @Bean
    @Qualifier("bookEntityManager")
    public SharedEntityManagerBean bookEntityManager(@Qualifier ("bookEntityManagerFactory") EntityManagerFactory bookEntityManagerFactory) {
        SharedEntityManagerBean bean  = new SharedEntityManagerBean();
        bean.setEntityManagerInterface(bookEntityManagerFactory);

        return bean;
    }

    @Configuration
    public static class GraphQLJpaQuerySchemaConfigurer implements GraphQLSchemaConfigurer {

        private final EntityManager entityManager;

        @Autowired
        private GraphQLJpaQuerySchemaConfigurer(@Qualifier("bookEntityManager")EntityManager bookEntityManager) {
            this.entityManager = bookEntityManager;
        }

        @Override
        public void configure(GraphQLSchemaRegistration registery) {
            registery.register(
                    new GraphQLJpaQuerySchemaConfigurer(entityManager)
                    .name("GraphQLBooks")
                    .useDistinctParameter(properties.isUseDistinctParameter())
                    .setDefaultDistinct(properties.isDefaultDistinct())
                    .build()
            );
        }

        @Override
        public void configure(GraphQLShemaRegistration graphQLShemaRegistration) {

        }
    }
}
