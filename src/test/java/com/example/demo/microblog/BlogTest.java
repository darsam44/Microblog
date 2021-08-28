package com.example.demo.microblog;

import com.example.demo.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;

class BlogTest {

    @Autowired
    private Blog b;

    @BeforeEach
    void setUp() {
        b = new Blog(
                "This is Dar Blog",
                "At this Blog i want to see if i can add"
        );
    }

    @Test
    void getBlogName() {
        String name = "This is Dar Blog";
        assertEquals(name , b.getBlogName());
    }

    @Test
    void setBlogName() {
        String name = "This is Dar Blog";
        b.setBlogName("checking not equals");
        assertNotEquals(name , b.getBlogName());
    }

    @Test
    void getText() {
        String text = "At this Blog i want to see if i can add";
        assertEquals(text , b.getText());
    }

    @Test
    void setText() {
        String text = "At this Blog i want to see if i can add";
        b.setText("checking not equals");
        assertNotEquals(text, b.getText());
    }

    @Test
    void getLikes() {
        Integer like = 0;
        assertEquals(like , b.getLikes());

    }

    @Test
    void setLikes() {
        Integer like = 2;
        b.setLikes(2);
        assertEquals(like , b.getLikes());
    }
}