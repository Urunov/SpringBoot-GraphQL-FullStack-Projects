const { GraphQLServer } = require('graphql-yoga')
const fetch = require('node-fetch')

const baseURL = `http://localhost:8080`

const resolvers = {
    Query: {
        websites: () => {
            return fetch(`${baseURL}/website`).then(res => res.json())
        },
        website: (parent, args) => {
            const { id } = args
            return fetch(`${baseURL}/website/${id}`).then(res => res.json())
        }
    },
    Mutation: {
        addWebsite: (parent, args) => {
            const website = {
                name: args.name,
                url: args.url,
            }
            return fetch(`${baseURL}/website`, {
                method: 'POST',
                body: JSON.stringify(website),
                headers: { 'Content-Type': 'application/json' }
            }).then(res => res.text());
        },
        updateWebsite: (parent, args) => {
            const website = {
                id: args.id,
                name: args.name,
                url: args.url,
            }
            return fetch(`${baseURL}/website`, {
                method: 'PUT',
                body: JSON.stringify(website),
                headers: { 'Content-Type': 'application/json' }
            }).then(res => res.text());
        },
        deleteWebsite: (parent, args) => {
            const website = {
                id: args.id
            }
            return fetch(`${baseURL}/website`, {
                method: 'DELETE',
                body: JSON.stringify(website),
                headers: { 'Content-Type': 'application/json' }
            }).then(res => res.text());
        }
    }
}

const server = new GraphQLServer({
    typeDefs: './src/schema.graphql',
    resolvers,
})

server.start(() => console.log(`Server is running on http://localhost:4000`))