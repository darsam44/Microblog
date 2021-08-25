package com.example.demo.service;

import com.example.demo.microblog.Blog;
import com.example.demo.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // ment to be a service class
public class BlogService {

    private  final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<Blog> getblogs()
    {
//        return blogRepository.findBlogByBlogname("Miraim").get();
        return (List<Blog>) blogRepository.findAll();
    }

    public Blog getblog(String blogname) {
        return blogRepository.findBlogByBlogname(blogname).get();
    }

    public void addNewBlog(Blog blog) {
        Optional<Blog> blogOptional =  blogRepository.findBlogByBlogname(blog.getBlogName());
        if(blogOptional.isPresent()){
            throw new IllegalStateException("blog name taken");
        }
        blogRepository.save(blog);
//        System.out.println(student);
    }

    @Transactional
    public void deleteblog(String Blogname) {
    Boolean exists = blogRepository.findBlogByBlogname(Blogname).isPresent();

    if (!exists){
        throw new IllegalStateException("blog with id " + Blogname + " does not exists" );
    }
        blogRepository.deleteBlogByBlogname(Blogname);
    }

    @Transactional
    public void Updateblog(Long studentId, String name, String email) {
    Blog student = blogRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists" ) );

    if ( name != null && name.length() > 0 && !Objects.equals(student.getBlogName() , name)){
        student.setBlogName(name);
    }
    if ( email != null && email.length() > 0 && !Objects.equals(student.getText() , email)){
            student.setText(email);
    }
    }


}


