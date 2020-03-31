package com.example.demo.Repo;

import com.example.demo.Model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post,Long> {
}
