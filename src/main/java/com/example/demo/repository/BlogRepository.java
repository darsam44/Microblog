package com.example.demo.repository;

import com.example.demo.microblog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//response on data acsseces
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{


    //SELECT * FROM student WHERE email = ?
//    @Query("SELECT s FROM Student  s Where s.email =?1")
    Optional<Blog> findStudentByText(String text);
}