package com.example.demo.service;

import com.example.demo.microblog.Blog;
import com.example.demo.repository.BlogRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;
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
    @Disabled
    void getblog() {
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

//    @Test
//    void willThrowWehnaddNewBlog() {
//        Blog b = new Blog(
//                "This is Dar Blog",
//                "At this Blog i want to see if i can add"
//        );
//
////    given(blogRepository.findBlogByBlogname(b.getBlogName()));
//        assertThatThrownBy(() -> underTest.addNewBlog(b)).isInstanceOf(IllegalStateException.class).hasMessageContaining("blog name taken");
//
//    }

    @Test
    @Disabled
    void deleteblog() {
    }

    @Test
    @Disabled
    void updateblog() {
    }

    @Test
    @Disabled
    void updatebloglike() {
    }
}