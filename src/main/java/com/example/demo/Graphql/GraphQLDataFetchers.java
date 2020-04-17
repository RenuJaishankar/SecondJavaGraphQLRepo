package com.example.demo.Graphql;

import com.example.demo.Model.FlowerPost;
import com.example.demo.Model.FruitPost;
import com.example.demo.Model.PlacePost;
import com.example.demo.Model.Post;
import com.example.demo.Repo.FlowerpostRepo;
import com.example.demo.Repo.FruitpostRepo;
import com.example.demo.Repo.PlacepostRepo;
import graphql.schema.DataFetcher;
import com.example.demo.Repo.PostRepo;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
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
    @Autowired
    FlowerpostRepo flowerpostRepo;
    @Autowired
    FruitpostRepo fruitpostRepo;
    @Autowired
    PlacepostRepo placepostRepo;
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
    private List<FlowerPost> flowerposts;
    private List<PlacePost>  placeposts;
    private List<FruitPost> fruitposts;
    public DataFetcher getPostsDataFetcher() {
        return dataFetchingEnvironment -> {
            posts = StreamSupport
                    .stream(postRepo.findAll().spliterator(), false)
                    .collect(Collectors.toList());
            return posts;
        };
    }

    public DataFetcher getFlowerPostsDataFetcher() {
        return dataFetchingEnvironment -> {
           flowerposts = StreamSupport
                   .stream(flowerpostRepo.findAll().spliterator(),false)
                   .collect(Collectors.toList());
             return flowerposts;
        };

    }
    public DataFetcher getPlacePostsDataFetcher() {
        return dataFetchingEnvironment -> {
            placeposts = StreamSupport
                    .stream(placepostRepo.findAll().spliterator(),false)
                    .collect(Collectors.toList());
            return placeposts;
        };

    }


    public DataFetcher getFruitPostsDataFetcher() {
        return dataFetchingEnvironment -> {
            fruitposts = StreamSupport
                    .stream(fruitpostRepo.findAll().spliterator(),false)
                    .collect(Collectors.toList());
            return fruitposts;
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
    public DataFetcher getPagedPostsDataFetcher()  {
         return dataFetchingEnvironment -> {
            int pageNumber = dataFetchingEnvironment.getArgument("pageNumber");
            int pageSize = dataFetchingEnvironment.getArgument("pageSize");
             Pageable pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
         //    Pageable firstPageWithTwoElements = PageRequest.of(pageNumber, pageSize);
             Page<Post> allposts = postRepo.findAll(pageRequest);
              return allposts;
         };
    }

    public DataFetcher getTotalPages(){
        return dataFetchingEnvironment -> {
            int pageNumber = dataFetchingEnvironment.getArgument("pageNumber");
            int pageSize = dataFetchingEnvironment.getArgument("pageSize");
            Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
            Page<Post> allPosts = postRepo.findAll(pageRequest);
            return allPosts.getTotalPages();
        };
    }


     public DataFetcher createPost(){
          return dataFetchingEnvironment -> {
              String postImageUrl=dataFetchingEnvironment.getArgument("imageUrl");
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
              String postTitle=dataFetchingEnvironment.getArgument("title");
          String postBody=dataFetchingEnvironment.getArgument("body");
          //Note that we are not defining id or date as these values will be handled for us by our program.
           Post newPost = new Post(sdf.format(new Date()),postTitle,postBody,postImageUrl);
           postRepo.save(newPost);
              posts = StreamSupport
                      .stream(postRepo.findAll().spliterator(), false)
                      .collect(Collectors.toList());
           return newPost;
          };
      }
     public DataFetcher createFlowerPost(){
       return dataFetchingEnvironment -> {
           String flowerpostImageUrl=dataFetchingEnvironment.getArgument("imageUrl");
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
           String flowerpostTitle=dataFetchingEnvironment.getArgument("title");
            String flowerpostBody=dataFetchingEnvironment.getArgument("body");

            FlowerPost newFlowerPost = new FlowerPost(sdf.format(new Date()),flowerpostTitle,
                    flowerpostBody, flowerpostImageUrl);
      //Note that we are not defining id or date as these values will be handled for us by our program.
      flowerpostRepo.save(newFlowerPost);
          flowerposts = StreamSupport
                        .stream(flowerpostRepo.findAll().spliterator(),false)
                  .collect(Collectors.toList());
          return newFlowerPost;
       } ;
     }
    public DataFetcher createPlacePost(){
        return dataFetchingEnvironment -> {
            String placepostImageUrl=dataFetchingEnvironment.getArgument("imageUrl");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String placepostTitle=dataFetchingEnvironment.getArgument("title");
            String placepostBody=dataFetchingEnvironment.getArgument("body");

            PlacePost newPlacePost = new PlacePost(sdf.format(new Date()),placepostTitle,
                    placepostBody, placepostImageUrl);
            //Note that we are not defining id or date as these values will be handled for us by our program.
            placepostRepo.save(newPlacePost);
            placeposts = StreamSupport
                    .stream(placepostRepo.findAll().spliterator(),false)
                    .collect(Collectors.toList());
            return newPlacePost;
        } ;
    }

    public DataFetcher createFruitPost(){
        return dataFetchingEnvironment -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String fruitpostTitle=dataFetchingEnvironment.getArgument("title");
            String fruitpostBody=dataFetchingEnvironment.getArgument("body");
            String fruitpostImageUrl=dataFetchingEnvironment.getArgument("imageUrl");
            FruitPost newFruitPost = new FruitPost(sdf.format(new Date()),fruitpostTitle,fruitpostBody,fruitpostImageUrl);
            //Note that we are not defining id or date as these values will be handled for us by our program.
            fruitpostRepo.save(newFruitPost);
            fruitposts = StreamSupport
                    .stream(fruitpostRepo.findAll().spliterator(),false)
                    .collect(Collectors.toList());
            return newFruitPost;
        } ;
    }





}