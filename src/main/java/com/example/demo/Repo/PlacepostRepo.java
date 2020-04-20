package com.example.demo.Repo;

import com.example.demo.Model.PlacePost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
//import org.springframework.data.repository.Repository;
import java.util.List;
//public interface PlacepostRepo extends CrudRepository<PlacePost,Long>{
public interface PlacepostRepo extends PagingAndSortingRepository<PlacePost,Long> {
}

