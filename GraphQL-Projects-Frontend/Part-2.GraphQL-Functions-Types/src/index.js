const{ApolloServer, gql} =require("apollo-server");

 
    // type checking
    // query vs. mutation
    //  objects
    //  arrays
    //  arguments
    //  crud 


const typeDefs = gql`

        type Query {
            hello: String!
            
        }

        type User {
            id: ID!
            username: String!    
        }

        type Mutation {
            register: User
        }

        type Error{
            field: String!
            message: String!
        }

        type RegisterResponse{
            errors: [Error]
            user: User
        }
    `;

    const resolvers = {
    
        Query:{
            hello: () => "Hello Friends! "
        },
        
        Mutation: {
            register: () => ({

                errors: null,
                // errors: [
                //     {
                //         field: 'username',
                //         message: 'Bad values'
                //     }
                // ],
                user:{
                    id: 1,
                    username: "Hamdamboy"
                }
               
            })
        }
    };

const server = new ApolloServer({typeDefs, resolvers});

server.listen().then(({ url }) => console.log(`server started at ${url}` ));