package graphql.error.resolver;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import graphql.error.model.User;
import graphql.error.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import static graphql.error.GraphQLSecurityTest.TEST_PASSWORD;
import static graphql.error.GraphQLSecurityTest.TEST_USERNAME;

/**
 * @Author: apple
 * @created on 20/08/2020
 * @Project is error
 */
@GraphQLTest
public class UserMutationintTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    UserService userServiceMock;

    static User user = new User();


    @BeforeAll
    static void setUp() {
        user.setUsername(TEST_USERNAME);
        user.setPassword(TEST_PASSWORD);
    }

    @Test
    public void createUser() throws IOException {
        doReturn(user).when(userServiceMock).createUser(TEST_USERNAME, TEST_PASSWORD);
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/create-user.graphql");
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.createUser.id")).isNotNull();
        assertThat(response.get("$.data.createUser.username")).isEqualTo(TEST_USERNAME);

    }

    @Test
    @WithMockUser(username = TEST_USERNAME, roles = "ADMIN")
    public void deleteUser() throws IOException {
        doReturn(user).when(userServiceMock).deleteUser(TEST_USERNAME);
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/delete-user.graphql");
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.deleteUser.id")).isNotNull();
        assertThat(response.get("$.data.deleteUser.username")).isEqualTo(TEST_USERNAME);

    }
}
