package graphql.error;

import com.graphql.spring.boot.test.GraphQLTestTemplate;
import graphql.error.exception.UnauthenticatedAccessException;
import graphql.error.resolvers.UserMutation;
import graphql.error.resolvers.UserQuery;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: apple
 * @created on 20/08/2020
 * @Project is FullStack
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GraphQLSecurityTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Autowired
    private UserMutation userMutation;

    @Autowired
    private UserQuery userQuery;


    public static final String TEST_USERNAME = "urunov";
    public static final String TEST_PASSWORD = "wide123";

    @Test
    @DisplayName("Access to Unsecured resource should be ok, my Friend.")
    public void unsecuredResourceOk() {
        userMutation.createUser(TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    @DisplayName("Unauthenticated Access to secured resource should be unauthorized")
    public void securedUnauthorizedAccessThrowsException() {
        Assertions.assertThrows(UnauthenticatedAccessException.class, () ->userQuery.getUser(TEST_USERNAME, TEST_PASSWORD));
    }

    @Test
    @DisplayName("Authenticated Access to secured resource should be ok, no problem")
    @WithMockUser(username = TEST_USERNAME)
    public void securedOk(){
        userMutation.createUser(TEST_USERNAME, TEST_PASSWORD);

        userQuery.getUser(TEST_USERNAME, TEST_PASSWORD);
    }

    @Test
    @DisplayName("Unauthenticated Access to Admin secured resource should be unauthorized!.")
    public void adminUnauthorizedAccessThrowsException(){

        Assertions.assertThrows(UnauthenticatedAccessException.class, ()->userMutation.deleteUser(TEST_USERNAME));
    }

    @Test
    @DisplayName("Unauthorized Access to admin secured resourced should be forbidden.")
    @WithMockUser(username = TEST_USERNAME)
    public void withoutAdminRoleThrowsException(){
        Assertions.assertThrows(UnauthenticatedAccessException.class, ()-> userMutation.deleteUser(TEST_USERNAME));
    }

    @Test
    @DisplayName("Admin Authorized Access to admin secured resource should be ok.")
    @WithMockUser(username = TEST_USERNAME, roles = "ADMIN")
    public void adminRoleOk(){
        userMutation.deleteUser(TEST_USERNAME);
    }
}

