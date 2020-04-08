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
//@Component
// commented because we add details through the front end post.
public class Runner implements CommandLineRunner {
    //ClassLoader is used to load classes into our program but it can handle resources as well. Specifically, it handles
    // resources as a stream, ergo the method getResourceAsStream. We pass in our resource path into it as a string.
    // The Scanners take in our streams as arguments, allowing us to later render the data. The default constructor
    // simply allows us to have the class throw an error; this is necessary for our InputStreams to work.
    ClassLoader cl = this.getClass().getClassLoader();
    InputStream inputStreamOne = cl.getResourceAsStream("posts/first.txt");
    InputStream inputStreamTwo = cl.getResourceAsStream("posts/second.txt");
    InputStream inputStreamThree = cl.getResourceAsStream("posts/third.txt");
    //This code allows our scanner to intrepet the content of our files as a string, and stops at the escaping
    // character \\A, ending the stream.
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
  //change the constructors for each new post so that it accepts our Strings that we defined in the previous step.
  postRepo.save(new Post(sdf.format(new Date()),"Welcome to my blog",textOne));
    postRepo.save(new Post(sdf.format(new Date()),"Have a look at this awesome post",textTwo));
    postRepo.save(new Post(sdf.format(new Date()),"My new post",textThree));
}

}
