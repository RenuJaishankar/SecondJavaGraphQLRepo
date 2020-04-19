package com.example.demo.Repo;

import com.example.demo.Model.PlacePost;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

//public interface PlacepostRepo extends CrudRepository<PlacePost,Long>{
public interface PlacepostRepo extends PagingAndSortingRepository<PlacePost,Long> {
}

