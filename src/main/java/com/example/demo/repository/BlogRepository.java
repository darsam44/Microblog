package com.example.demo.repository;

import com.example.demo.microblog.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//response on data acsseces
@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {


    //SELECT * FROM student WHERE email = ?
//    @Query("SELECT s FROM Blog  s Where s.Blogname =?1")
    Optional<Blog> findBlogByBlogname(String name);
    Optional<Blog> deleteBlogByBlogname(String name);


}