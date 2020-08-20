package graphql.error.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

/**
 * @Author: apple
 * @created on 20/08/2020
 * @Project is FullStack
 */

public class UnauthenticatedAccessException extends RuntimeException implements GraphQLError {

    public UnauthenticatedAccessException(String msg) {
        super(msg);
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
