package graphql.error.resolver;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import graphql.error.model.User;
import graphql.error.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import static graphql.error.GraphQLSecurityTest.TEST_PASSWORD;
import static graphql.error.GraphQLSecurityTest.TEST_USERNAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

/**
 * @Author: apple
 * @created on 20/08/2020
 * @Project is error
 */
@GraphQLTest
public class UserQueryIntTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    UserService userServiceMock;


    @Test
    @WithMockUser(username = TEST_USERNAME)
    public void getUser() throws Exception {

        User user = new User();
        user.setUsername(TEST_USERNAME);
        user.setPassword(TEST_PASSWORD);
        doReturn(user).when(userServiceMock).getUser(TEST_USERNAME, TEST_PASSWORD);

        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/get-user.graphql");
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.getUser.id")).isNotNull();
        assertThat(response.get("$.data.getUser.username")).isEqualTo(TEST_USERNAME);
    }
}
