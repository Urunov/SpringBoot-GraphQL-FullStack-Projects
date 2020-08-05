package com.online.graphql.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: apple
 * @created on 04/08/2020
 * @Project is version1_7_step
 */
public class OrderNotFoundException extends RuntimeException implements GraphQLError {

    private Map<String, Object> extensions = new HashMap<>();


    public OrderNotFoundException(String message, Long invalidOrderId){
        super(message);
        extensions.put("invalid Order ", invalidOrderId);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }
}

