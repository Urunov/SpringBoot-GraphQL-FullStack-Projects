package book.project.type;

import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GraphQLLocalDate extends GraphQLScalarType {

    public GraphQLLocalDate() {
        super("LocalDate", "Local Date Type", new Coercing<LocalDate, String>() {

            @Override
            public String serialize(Object result) throws CoercingSerializeException {
                if (result instanceof LocalDate) {
                    return ((LocalDate) result).toString();
                }
                return null;
            }

            @Override
            public LocalDate parseValue(Object input) throws CoercingParseValueException {
                if (input instanceof String) {
                    return LocalDate.parse((String) input);
                }
                return null;
            }

            @Override
            public LocalDate parseLiteral(Object input) throws CoercingParseLiteralException {
                if (!(input instanceof StringValue)) return null;
                return LocalDate.parse(((StringValue) input).getValue());
            }
        });
    }
}
