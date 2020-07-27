package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
//    Iterable<Director> findAllByIdGreaterThanOrderByName(long id);
}
