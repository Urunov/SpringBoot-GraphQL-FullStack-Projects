package com.urunov;

import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.execution.instrumentation.tracing.TracingInstrumentation;
import graphql.schema.visibility.BlockedFields;
import graphql.servlet.GraphQLContext;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Supplier;
import java.util.logging.Logger;

@SpringBootApplication
@EnableTransactionManagement
public class JpaApplication {

    private static final Logger logger  = (Logger) LoggerFactory.getLogger(JpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    @RequestScope
    public Spupplier <GraphQLFieldVisibility> graphqlFieldVisibility(HttpServletRequest request){
        return () -> !request.isSecure() ? BlockedFields.newBlock()
                                                        .addPattern("Book.price")
                                                        .build()
                :DEFAULT_FILED_VISIBILITY;
    }

    @Bean
    @RequestScope
    public Supplier<GraphQLContext> graphqlContext(HttpServletRequest request) {
        return () -> GraphQLContext.newContext()
                .of("request", request)
                .of("user", request)
                .build();
    }

    @Bean
    @RequestScope
    public Supplier<Instrumentation> instrumentation(HttpServletRequest request) {
        return () -> logger.isDebugEnabled()
                ? new TracingInstrumentation()
                : SimpleInstrumentation.INSTANCE;
    }

}
