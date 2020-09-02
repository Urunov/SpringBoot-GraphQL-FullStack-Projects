--------------------------
Part-1. Project: GraphQL-JPA-MySQL
      
 *  We will create two tables Category and Product. So each product must belong to a category and a category may have multiple products under it. So Product will have many-to-one relationship with Category.
 * We are going to use Spring Data JPA to perform database activities using Spring’s built-in API JpaRepository that provides functions for performing basic CRUD operations out of the box.
 
 <img width="1440" alt="Screen Shot 2020-08-30 at 10 22 21 PM" src="https://user-images.githubusercontent.com/11626327/91660234-24586b80-eb10-11ea-8b45-53a7c35150b7.png">



Part-4. Project: GraphQL-Spring-Customer-Projects

## We are adding following dependencies:

* spring-data-jpa and h2 for creating data repositories to store customers, products and orders.
* graphql-spring-boot-starter for adding GraphQL Java support with Spring Boot.
* graphql-java-tools is schema first tool inspired from GraphQL Tool for JS which let us design the schema first and generate all boilerplate graphql java configuration.
* graphiql-spring-boot-starter adds support for GraphiQL (notice the extra ‘i’). GraphiQL provides nice editor to query and introspect GraphQL API.

Since we are using GraphQL Java Spring Boot, we need to fix the kotlin version to 1.3.10.

## Create maven.properties file and add following code in it. [Maven dependency](https://github.com/Urunov/SpringBoot-GraphQL-FullStack-Projects/tree/master/GraphQL-JPA-Query/Part-4.%20GraphQL-Spring-Customer-Projects) . (in my project) and gradle project [here](https://www.viralpatel.net/graphql-spring-boot-tutorial/) 


![Screen Shot 2020-09-02 at 5 41 26 PM](https://user-images.githubusercontent.com/11626327/91959440-9238a900-ed43-11ea-841e-804c1b97c44a.png)

DB (H2) 
![Screen Shot 2020-09-02 at 5 42 56 PM](https://user-images.githubusercontent.com/11626327/91959579-c2804780-ed43-11ea-813a-d1f28ce1d24a.png)

Resource: 
 1. [GraphQL CRUD](https://www.roytuts.com/graphql-spring-mysql-crud-example/)
 2. [GraphQL in Project](https://www.viralpatel.net/graphql-spring-boot-tutorial/)
