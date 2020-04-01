"# SecondJavaGraphQLRepo"
Let's create a new GraphQL backend, this time utilizing h2 for more rapid development. Go to [https://start.spring.io/](the Sring Initializer) and select the following:
Spring Web
Spring Data JPA
H2 Database
This project is done with H2 database.
Using Graphql.
Dependencies are added for GraphQL in build.gradle.
Changes are made in application properties as well.

In my project in build.gradle I added the following to my dependencies:
	implementation 'com.graphql-java:graphql-java:11.0'
	implementation 'com.graphql-java:graphql-java-spring-boot-starter-webmvc:1.0'
	implementation 'com.google.guava:guava:26.0-jre'
