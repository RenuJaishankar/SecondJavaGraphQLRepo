package com.example.demo.Repo;

import com.example.demo.Model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

public interface PostRepo extends PagingAndSortingRepository<Post,Long> {
}
