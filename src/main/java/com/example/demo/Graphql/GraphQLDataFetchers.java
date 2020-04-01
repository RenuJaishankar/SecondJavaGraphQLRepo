package com.example.demo.Graphql;

import com.example.demo.Model.Post;
import graphql.schema.DataFetcher;
import com.example.demo.Repo.PostRepo;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

// This component acts as a way to fetch and access our data
// You can call this component your service
// its taking care of all of your business logic
@Component
public class GraphQLDataFetchers {
    @Autowired
    PostRepo postRepo;
    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "author-1"),
            ImmutableMap.of("id", "book2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "author-2"),
            ImmutableMap.of("id", "book3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3")
    );
    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"
            ),
            ImmutableMap.of("id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"
            ),
            ImmutableMap.of("id", "author-3",
                    "firstName", "Anne",
                    "lastName", "Rice")

    );
    private List<Post> posts;

    public DataFetcher getPostsDataFetcher() {
        return dataFetchingEnvironment -> {
            posts = StreamSupport
                    .stream(postRepo.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            return posts;
        };
    }
    public DataFetcher getBooksDataFetcher() {
        return dataFetchingEnvironment -> {

            return books;
        };
    }

    public DataFetcher getBookByIdDataFetcher(){
        // DataFetchingEnvironment is like an anonymous inner class
        // it's technically a functional interface: this is more succint...
        // ...specifically calls the get method inside of the interface
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);

        };
    }
    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authors.
                    stream()
                    .filter(author -> author.get("Id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }
     public DataFetcher createPost(){
          return dataFetchingEnvironment -> {
            String date=dataFetchingEnvironment.getArgument("date");
          String title=dataFetchingEnvironment.getArgument("title");
          String body=dataFetchingEnvironment.getArgument("body");
           Post newPost = new Post(date,title,body);
           postRepo.save(newPost);
           return newPost;
          };
      }

}