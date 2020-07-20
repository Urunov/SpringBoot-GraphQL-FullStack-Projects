const {ApolloServer, gql} = require('apollo-server');

const typeDefs = gql `

type Query {
    hello: String!
}
`;

const resolvers = {
    Query:{
        hello: () => "Hello, The World! "
    }
};

const server = new ApolloServer({typeDefs, resolvers});

server.listen().then(({url})=> console.log(`Server started at ${url}`));