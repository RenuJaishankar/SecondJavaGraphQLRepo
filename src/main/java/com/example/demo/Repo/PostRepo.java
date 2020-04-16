package com.example.demo.Repo;

import com.example.demo.Model.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.Repository;
import java.util.List;
public interface PostRepo extends PagingAndSortingRepository<Post,Long> {
}
