package com.example.demo.Repo;

import com.example.demo.Model.FlowerPost;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FlowerpostRepo extends PagingAndSortingRepository<FlowerPost,Long> {
}
