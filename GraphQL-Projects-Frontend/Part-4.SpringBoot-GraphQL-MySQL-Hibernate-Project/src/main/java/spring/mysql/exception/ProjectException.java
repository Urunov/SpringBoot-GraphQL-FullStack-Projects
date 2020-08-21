package spring.mysql.exception;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */
public class ProjectException extends AbstractGraphqlException {
    public ProjectException(int errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
