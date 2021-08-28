package com.example.demo.service;

import com.example.demo.microblog.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class BlogService {

    private  final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Iterable<Blog> getblogs()
    {
        List<Blog> blog = (List<Blog>) blogRepository.findAll();
        Collections.sort(blog); //sort the Blog by likes and time of create
        return blog;
    }

    public Blog getBlogByName(String blogname) {
        if(blogRepository.findBlogByBlogname(blogname).isEmpty()){
            throw new IllegalStateException("There isn't any Blog with " + blogname + " name");
        }
        return blogRepository.findBlogByBlogname(blogname).get();
    }

    public Blog getBlogById(Long blogId) {
        if(blogRepository.findById(blogId).isEmpty()){
            throw new IllegalStateException("Blog with id " + blogId + " does not exists");
        }
        return blogRepository.findById(blogId).get();
    }

    public void addNewBlog(Blog blog) {
        Optional<Blog> blogOptional =  blogRepository.findBlogByBlogname(blog.getBlogName());
        if(blogOptional.isPresent()){
            throw new IllegalStateException("This Blog name is already exists");
        }
        if(blog.getBlogName() == null || blog.getBlogName().length() < 1){
            throw new IllegalStateException("You must give name to blog");
        }
        Blog b = new Blog(blog.getBlogName() , blog.getText());
        blogRepository.save(b);
    }


    @Transactional
    public void deleteblog(Long blogId) {
        boolean exists = blogRepository.existsById(blogId);

        if (!exists){
            throw new IllegalStateException("Blog with Id " + blogId + " does not exists" );
        }
        blogRepository.deleteById(blogId);
    }

    @Transactional
    public void Updateblog(Long blogId, String name, String text) {
    Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new IllegalStateException("Blog with id " + blogId + " does not exists" ) );

    if ( name != null && name.length() > 0 && !Objects.equals(blog.getBlogName() , name)){
        blog.setBlogName(name);
    }
    if ( text != null && text.length() > 0 && !Objects.equals(blog.getText() , text)){
        blog.setText(text);
    }
    }

    @Transactional
    public void Updatebloglike(Long blogId) {
        boolean exists = blogRepository.existsById(blogId);
        if (!exists){
            throw new IllegalStateException("Blog with Id " + blogId + " does not exists" );
        }
        Blog blog = blogRepository.findById(blogId).get();
        Integer Likes = blog.getLikes();
        Likes++;
        blog.setLikes(Likes);
    }

}


