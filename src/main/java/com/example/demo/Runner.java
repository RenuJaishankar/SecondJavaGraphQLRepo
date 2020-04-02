package com.example.demo;

import com.example.demo.Graphql.GraphQLDataFetchers;
import com.example.demo.Model.Post;
import com.example.demo.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


@Component
public class Runner implements CommandLineRunner {
    ClassLoader cl = this.getClass().getClassLoader();
    InputStream inputStreamOne = cl.getResourceAsStream("posts/first.txt");
    InputStream inputStreamTwo = cl.getResourceAsStream("posts/second.txt");
    InputStream inputStreamThree = cl.getResourceAsStream("posts/third.txt");

    Scanner scannerOne = new Scanner(inputStreamOne);
    Scanner scannerTwo = new Scanner(inputStreamTwo);
    Scanner scannerThree = new Scanner(inputStreamThree);
// this object allows me to format the Date object however I see

SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
@Autowired
    GraphQLDataFetchers graphQLDataFetchers;
@Autowired
PostRepo postRepo;
public Runner() throws IOException {

}
String textOne = scannerOne.useDelimiter("\\A").next();
String textTwo = scannerTwo.useDelimiter("\\A").next();
String textThree = scannerThree.useDelimiter("\\A").next();
@Override
public void run(String... args) throws Exception{
  postRepo.save(new Post(sdf.format(new Date()),"hello",textOne));
    postRepo.save(new Post(sdf.format(new Date()),"new post",textTwo));
    postRepo.save(new Post(sdf.format(new Date()),"other rambling",textThree));
}

}
