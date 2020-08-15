# GraphQL Project Frontend 


    
   
## Configuration table
  
   | Components  | Technology  | 
   | :---        |    :----:   |   
   | Frontend  | GraphQL  | 
   | Backend   |   |
   | Client Build |yarn|
   | Server Build| yarn |
   | Tool | Visual Studio Code |
 
 
## 1. Part-1.GraphQL-HelloWorld
 
 Step by Step explanation: 
 --------------------------------------------------------
  Open the web site and make sure / Get started
    1. [graphql.org] (graphql.org)

  Open Visual Studio Code (VSC) and typing this command by( terminal)  
    2. Terminal type the same command
    
         --> yarn init -y

         --> yarn add apollo-server graphql
  
  3. create folder (src) and index.js. You may use abover source code. After finished, back your terminal
         
         --> node src/index.js

  4. localhost:4000

            -> open your broweser.
                query {
                   hello
                }
   
   
-------------------------------------------------------------------------------------   
   
## 2. Part-2.GraphQL-Functions-Types
 
 Open VSC and typing this command by( terminal)  
 
  1. Terminal type the same command (Auto server recompile without restart)
              --> yarn add -D nodemon
  2. Add this nodemon command to package.json
            "scrips" :{
              "start": "nodemon src/index.js" 
             }
  3. Terminal 
             --> yarn start (or npm start)
  4. Type resource of the GraphQL Language Cheat Sheet
        
   * [GraphQL Schema Language Cheat Sheet](https://wehavefaces.net/graphql-shorthand-notation-cheatsheet-17cd715861b6)
   * [Source Code](https://github.com/sogko/graphql-schema-language-cheat-sheet)

--------------------------------------


[Spring Boot and GraphQL ](https://www.viralpatel.net/graphql-spring-boot-tutorial/)
![GraphQL SpringBoot](https://user-images.githubusercontent.com/11626327/87937048-e60e6c00-cace-11ea-8760-a7fb7ebb2502.PNG)
--------------------------------------------------------------------------------------
# Part-3. Spring Boot GraphQL project (API)
   
    * Create Book and Update 
    * Adding Author
    * POSTMAN
    * H2 DB
    
<img width="1280" alt="Screen Shot 2020-08-14 at 3 11 30 PM" src="https://user-images.githubusercontent.com/11626327/90311681-8faf1480-df38-11ea-9c0e-862c3aaa4307.png">
  
-------------------------
# Part-5.Spring Boot and GraphQL project 

   ## Adding Maven Dependencies 
    * Create a sample Spring Boot application and add the following dependencies.
       -> graphql-spring-boot-starter is used for enabling GraphQL servlet and it becomes available at a path /graphql. It initializes GraphQLSchema bean.
       -> graphql-java allows to write schema with GraphQL schema language which is simple to understand.
    graphiql-spring-boot-starter provides user interface using which we could test our GraphQL queries and view query definition.
    
 [Resource](https://itnext.io/beginners-guide-to-graphql-with-spring-boot-69d229e87b19) 
    
-------------------------
## Resources 
1. [GraphQL for beginner](https://www.youtube.com/watch?v=Y78PadVft7I&list=PLN3n1USn4xln0j_NN9k4j5hS1thsGibKi&index=2)
2. [Moving Existing API From REST To GraphQL](https://www.youtube.com/watch?v=broQmxQAMjM)
3. [Spring Boot and GraphQL](https://www.viralpatel.net/graphql-spring-boot-tutorial/)
4. [Beginener to Super advanced](https://itnext.io/beginners-guide-to-graphql-with-spring-boot-69d229e87b19)



