package graphql.error.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import graphql.error.model.User;
import graphql.error.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 19/08/2020
 * @Project is FullStack
 */
@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public User getUser(String username, String password) {
        return userService.getUser(username, password);
    }
}
