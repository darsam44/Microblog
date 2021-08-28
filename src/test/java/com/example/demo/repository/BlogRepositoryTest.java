package com.example.demo.repository;

import com.example.demo.microblog.Blog;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BlogRepositoryTest {

    @Autowired
    private BlogRepository underTest;

    @AfterEach
    void tearDown() {
    underTest.deleteAll();
    }



    @Test
    void checkIfFindByName() {
        Blog b = new Blog(
                 "This is Dar Blog",
                 "At this Blog i want to see if i can add"
        );
        underTest.save(b);
        boolean flag = underTest.findBlogByBlogname("This is Dar Blog").isPresent();
        assertTrue(flag);
    }

    @Test
    void checkIfNotFindByName() {
        Blog b = new Blog(
                "This is Dar Blog",
                "At this Blog i want to see if i can add"
        );
        underTest.save(b);
        boolean flag = underTest.findBlogByBlogname("This is Dar").isPresent();
        assertFalse(flag);

    }

    @Test
    void deleteBlogByBlogname() {
        Blog b = new Blog(
                "This is Dar Blog",
                "At this Blog i want to see if i can add"
        );
        underTest.save(b);
        underTest.delete(b);
        boolean flag = underTest.findBlogByBlogname("This is Dar Blog").isPresent();
        assertFalse(flag);
    }
}