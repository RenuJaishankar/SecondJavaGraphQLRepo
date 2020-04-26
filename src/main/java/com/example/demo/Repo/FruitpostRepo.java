package com.example.demo.Repo;

import com.example.demo.Model.FruitPost;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import java.util.List;
public interface FruitpostRepo extends PagingAndSortingRepository<FruitPost,Long> {
}
