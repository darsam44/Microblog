package com.example.demo.controller;


import com.example.demo.microblog.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/blog")
public class BlogController {


    private  final BlogService blogService;


    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/trending")
    public List<Blog> getBlogs(){

        return blogService.getblogs();
    }

    @GetMapping(value = "/trending/{Blogname}" )
    public Blog getBlog(@PathVariable String Blogname){

        return blogService.getblog(Blogname);
    }

    @PostMapping
    public void makeNewSBlog (@RequestBody Blog blog){
        blogService.addNewBlog(blog);
    }

    @DeleteMapping("/delete")
    public void deleteBlog(@RequestParam(value = "name") String name){
        blogService.deleteblog(name);
    }

    @PutMapping(path = "{blogId}")
    public void updateBlog(
            @PathVariable("blogId") Long blogId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

        blogService.Updateblog(blogId , name , email);
     }

}
