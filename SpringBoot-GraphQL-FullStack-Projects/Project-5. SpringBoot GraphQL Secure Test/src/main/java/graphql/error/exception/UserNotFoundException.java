package graphql.error.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: apple
 * @created on 19/08/2020
 * @Project is FullStack
 */

public class UserNotFoundException extends RuntimeException implements GraphQLError {


    private String invalidField;

    public UserNotFoundException(String message, String invalidField) {
        this(message);
        this.invalidField  = invalidField;
    }

    public UserNotFoundException(String message) {
        super(message);
    }


    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }

    @Override
    public List<Object> getPath() {
        return null;
    }

    @Override
    public Map<String, Object> toSpecification() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("invalidField", invalidField);
    }
}
