package graphql.error.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import graphql.error.model.User;
import graphql.error.security.AdminSecured;
import graphql.error.security.Unsecured;
import graphql.error.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 19/08/2020
 * @Project is FullStack
 */
@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    @Unsecured
    public User createUser(String username, String password) {
        return userService.createUser(username, password);
    }

    @AdminSecured
    public User deleteUser(String username) {
        return userService.deleteUser(username);
    }

}
