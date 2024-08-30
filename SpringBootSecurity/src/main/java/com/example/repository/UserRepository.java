package com.example.repository;



import com.example.model.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<MyUser,Integer> {
    MyUser findByLogin(String name);
}
