package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//jpa repo is generic so we gave a type post as entity type we have given key data type id as long
// in post so we have given long here

public interface PostRepository extends JpaRepository<Post, Long> {


}
