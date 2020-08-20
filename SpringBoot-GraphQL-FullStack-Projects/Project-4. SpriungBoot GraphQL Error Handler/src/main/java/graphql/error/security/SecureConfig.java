package graphql.error.security;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: apple
 * @created on 20/08/2020
 * @Project is FullStack
 */

@EnableWebSecurity
/**Enable security checking at the method level with annotation support*/
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecureConfig extends WebSecurityConfigurerAdapter {

    public void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                //authorize all graphQL queries as well filter request at the resolvers level
                .antMatchers("/graphql").permitAll()

                //authorize request from graphql related apps that we will need
                .antMatchers("/graphiql").permitAll()
                .antMatchers("/vendor/**").permitAll()

                //any other requests should be authenticated
                .anyRequest().authenticated();

    }
}
