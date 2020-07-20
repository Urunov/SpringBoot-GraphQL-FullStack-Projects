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
 
 * Open VSC and typing this command by( terminal)  
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

         
    
   
   
# 2. FullStack projects Spring Boot and GraphQL 
