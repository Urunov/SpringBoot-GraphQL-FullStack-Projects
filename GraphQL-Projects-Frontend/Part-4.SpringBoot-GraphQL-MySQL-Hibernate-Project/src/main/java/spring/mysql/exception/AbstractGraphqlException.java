package spring.mysql.exception;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: apple
 * @created on 21/08/2020
 * @Project is SpringGraphQLMySQL
 */
public class AbstractGraphqlException extends RuntimeException implements GraphQLError{

    private int errorCode;
    private String errorMessage;

    public AbstractGraphqlException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public Map<String, Object> getExtensions() {
        Map<String, Object> customAttribute = new LinkedHashMap<>();
        customAttribute.put("errorCode", this.errorCode);
        customAttribute.put("errorMessage", this.errorMessage );
        return customAttribute;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}
