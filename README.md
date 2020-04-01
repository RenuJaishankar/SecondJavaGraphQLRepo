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
	
Though you can build your project using gradlew build and upload the .jar, it's actually simpler to go to your project root and write heroku create in a terminal.

In your application.properties, make sure you have the following line: server.port=${PORT:8080}.

Once you've done that, you can simply type git push heroku master to push to your heroku remote. Heroku will detect your spring app and build it using gradle!

If you attempt to open your page in Chrome, you'll more than likely get a whitelabel error. If you want to test out your api, plug in the URL of your heroku app into postman and test it out that way. Remember to add /graphql at the end of the URL.	

git add . 
gradlew
 git commit -m "first commit",
 and then 
 git push heroku master
 
 This will create an Heroku app in the location
 click the URL
 https://banana-crumble-91508.herokuapp.com/
 This gives whilelabel error in chrome.
 In postman
  https://banana-crumble-91508.herokuapp.com/graphql
  and in body
  give the query
  query{

   books{
       id
       name
       pageCount
     }

     }
and then it renders the output

{
    "data": {
        "books": [
            {
                "id": "book1",
                "name": "Harry Potter and the Philosopher's Stone",
                "pageCount": 223
            },
            {
                "id": "book2",
                "name": "Moby Dick",
                "pageCount": 635
            },
            {
                "id": "book3",
                "name": "Interview with the vampire",
                "pageCount": 371
            }
        ]
    }
}