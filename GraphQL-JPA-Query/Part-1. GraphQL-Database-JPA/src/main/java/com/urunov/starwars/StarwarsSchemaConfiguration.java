package com.urunov.starwars;

import com.introproventures.graphql.jpa.query.autoconfigure.GraphQLSchemaConfigurer;
import com.introproventures.graphql.jpa.query.autoconfigure.GraphQLShemaRegistration;
import com.introproventures.graphql.jpa.query.schema.impl.GraphQLJpaSchemaBuilder;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.jpa.AvailableSettings;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;

import javax.activation.DataSource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: apple
 * @created on 28/08/2020
 * @Project is GraphQL-JPA
 */
@Configuration
public class StarwarsSchemaConfiguration {

    public DataSource starWarDataSource(){
        return (DataSource) DataSourceBuilder.create().build();
    }

    @Bean
    public ApplicationRunner starWarsDataSourceInitializer(@Qualifier("starWarsDataSource") starWarsDataSource) {
        return (args) -> {
            ResourceLoader resourceLoader = new DefaultResourceLoader();

            ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
            databasePopulator.addScript(resourceLoader.getResource("starwars.sql"));

            databasePopulator.execute(starWarDataSource);
        };
    }

    public LocalContainerEntityManagerFactoryBean starWarsEntityFactory(EntityManagerFactoryBuilder builder,
                                                                        @Qualifier("starWarsDataSource") DataSource starWarsDataSource) {

        Map<String, Object> properties = new HashMap<>();
        properties.put(AvailableSettings.HBM2DDL_AUTO, "create-drop");
        properties.put(AvailableSettings.HBM2DLL_CREATE_SCHEMAS, "true");
        properties.put(AvailableSettings.DIALECT, H2Dialect.class.getName());
        properties.put(AvailableSettings.SHOW_SQL, "true");
        properties.put(AvailableSettings.FORMAT_SQL, "true");

        return builder
                .dataSource(starWarsDataSource)
                .packages(Droid.class)
                .persistenceUnit("starwars")
                .properties(properties)
                .build();
    }


    @Bean
    @Qualifier("starWarsEntityManager")
    public SharedEntityManagerBean starWarsEntityManager(@Qualifier("starWarsEntityManagerFactory") EntityManagerFactory entityManager) {
        SharedEntityManagerBean bean = new SharedEntityManagerBean();
        bean.setEntityManagerFactory(entityManager);

        return bean;
    }

    @Configuration
    public static class GraphQLJpaQuerySchemaConfigurer implements GraphQLSchemaConfigurer {

        private final EntityManager entityManager;

        public GraphQLJpaQuerySchemaConfigurer(@Qualifier("starWarsEntityManager") EntityManager starWarsEntityManager,
                                               @Qualifier("starWarsEntityManager") EntityManager starWarsEntity) {
            this.entityManager = starWarsEntityManager;
        }



        @Override
        public void configure(GraphQLShemaRegistration graphQLShemaRegistration) {
            graphQLShemaRegistration.register(new GraphQLJpaSchemaBuilder(entityManager).name("GraphQLStarWars").build());

        }
    }

}
