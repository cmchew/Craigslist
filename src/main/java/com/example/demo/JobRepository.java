package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long>{
//    Iterable<Movie> findAllByIdGreaterThanOrderByName(long id);
}
