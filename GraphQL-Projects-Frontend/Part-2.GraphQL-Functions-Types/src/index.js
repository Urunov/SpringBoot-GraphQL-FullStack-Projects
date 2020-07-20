const{ApolloServer, gql} =require("apollo-server");

/**
 * 
 *  ->  type checking
 *  ->  query vs. mutation
 *  ->  objects
 *  ->  arrays
 *  ->  arguments
 *  ->  crud 
*/


const typeDefs = gql`
    type Query {
        hello: String!
         
    }
    type User {
        id: ID!
        username: String!    
    }

    type Error {
        field: String!
        message: String!
    }

    type RegisterResponse {
        errors: [Error!]!
        user: User
    }

    input UserInfo {
        username: String!
        password: String!
        age: Int
    }

    type Mutation {
        register(userInfo: UserInfo!): RegisterResponse!
        login(userInfo: UserInfo): Boolean!
    }
    `;

const resolvers = {
    Query:{
        hello: () => "Hello Friends! ",
        user: () => ({
            id: 1, 
            username: "Hamdamboy"
        })
    },

    Mutation: {
        login:() => true,

        register:()=> ({

            errors:
            [
                {
                    field: "username",
                    message: "Please, update data..."
                },
                {
                    field: "username2",
                    message: "Bad2"
                }    
            ],
            user: {
                id: 1,
                username: "Halid"
            }    
        })
    }
};

const server = new ApolloServer({typeDefs, resolvers});

server.listen().then(({ url }) => console.log(`server started at ${url}` ));