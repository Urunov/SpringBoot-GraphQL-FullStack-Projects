[![Build Status](https://travis-ci.org/SuperEvenSteven/spring-boot-graphql-example.svg?branch=master)](https://travis-ci.org/SuperEvenSteven/spring-boot-graphql-example) [![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)

# Spring Boot GraphQL Full Stack Project

This is a simple maven-based Java example that uses spring-boot, an H2 embedded in-memory database and Hibernate ORM to stand up a graphql service. This example is self-contained and ready to play with after running ```mvn spring-boot:run```

The example defines a basic JPA annontated data model containing a single entity, Person. When spring-boot runs it takes that entity definition and creates an in-memory H2 embedded database with pre-poluated dummy data. The GraphQL service is then started and the H2 data is offered as a queryable repository accessible through the GraphQL API found at http://localhost:8080/.

![Screen Shot 2020-08-05 at 6 40 57 PM](https://user-images.githubusercontent.com/11626327/89398335-edc74500-d74b-11ea-9ed3-65113634608d.png)


## Compiling and Running
This project was compiled and tested using JDK8 and Maven 3.6.1 or upgraded.

### Starting the Service
Run the following to compile and run the example GraphQL service.

```bash
mvn spring-boot:run
```

### Stopping the Service
Use CTRL+C to stop.

## Exploring the GraphQL Service
In addition to a GraphQL runtime and API, this project starts up two graphical interfaces, GraphiQL and H2-Console to play around with.

### GraphiQL 
A web console that can be used to explore the schema and test querying the GraphQL API.
Found at: http://localhost:8080

The left-hand pane is used to input your client-side GraphQL queries. The right-hand pane displays the result returned back from this GraphQL service.



### Hibernate MySQL and H2-Console 

A web console to manage the H2 in-memory database. Found at: http://localhost:8080/h2-console (login credentials are found in [application.properites](src/main/resources/application.properties))




**Note:** be very careful not to blat an existing db schema by ensuring ```spring.jpa.hibernate.ddl-auto=none``` is included as above.

## Useful Links
* [graphql.org - schema documentation](https://graphql.org/learn/schema/)
* [graphql.org - best practices](https://graphql.org/learn/best-practices/)
* [graphql-java.com - getting started with GraphQL and Spring Boot](https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/)
* [pluralsight.com - similar tutorial](https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot)
* [graphqlmaster.com - input object types as mutation arguments](https://graphqlmastery.com/blog/input-object-type-as-an-argument-for-graphql-mutations-and-queries)

## License
For all files in this repository that don't contain explicit licensing, the MIT license then applies. See the accompanying LICENSE for more details.

