package com.example.demo;

import com.example.demo.Graphql.GraphQLDataFetchers;
import com.example.demo.Model.Post;
import com.example.demo.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class Runner implements CommandLineRunner {
// this object allows me to format the Date object however I see

SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
@Autowired
    GraphQLDataFetchers graphQLDataFetchers;
@Autowired
PostRepo postRepo;
@Override
public void run(String... args) throws Exception{
  postRepo.save(new Post(sdf.parse("2020/03/30"),"hello","fdffssdf"));
    postRepo.save(new Post(sdf.parse("2020/03/30"),"new post","fdsdfgihk"));
    postRepo.save(new Post(sdf.parse("2020/03/30"),"other rambling","32356rhsghjkl"));
}

}
