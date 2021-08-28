package com.example.demo.service;

import com.example.demo.microblog.Blog;
import com.example.demo.repository.BlogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;
    private BlogService underTest;

    @BeforeEach
    void setUp() {
        underTest = new BlogService(blogRepository);
    }


    @Test
    void getblogs() {
        //when
    underTest.getblogs();
    //then
    verify(blogRepository).findAll();
    }


    @Test
    void addNewBlog() {
        Blog b = new Blog(
                "This is Dar Blog",
                "At this Blog i want to see if i can add"
        );
        underTest.addNewBlog(b);

        ArgumentCaptor<Blog> blogArgumentCaptor = ArgumentCaptor.forClass(Blog.class);
        verify(blogRepository).save(blogArgumentCaptor.capture());
        Blog captuerdBlog = blogArgumentCaptor.getValue();
        assertThat(captuerdBlog.toString()).isEqualTo(b.toString());
    }
}