package com.example.demo.controller;


import com.example.demo.microblog.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/blog")
public class BlogController {


    private  final BlogService blogService;


    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/trending")
    public Iterable<Blog> getBlogs(){

        return blogService.getblogs();
    }

    @GetMapping(value = "/trending/{Blogname}" )
    public Blog getBlogByName(@PathVariable String Blogname){

        return blogService.getBlogByName(Blogname);
    }

    @GetMapping(value = "/trending/{Id}" )
    public Blog getBlogById(@PathVariable Long Id){

        return blogService.getBlogById(Id);
    }

    @PostMapping
    public void makeNewSBlog (@RequestBody Blog blog){
        blogService.addNewBlog(blog);
    }

    @DeleteMapping("/delete")
    public void deleteBlog(@RequestParam(value = "Id") Long Id){
        blogService.deleteblog(Id);
    }

    @PutMapping(path = "{blogId}")
    public void updateBlog(
            @PathVariable("blogId") Long blogId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {

        blogService.Updateblog(blogId , name , email);
     }

    @PutMapping("/Upvote")
    public void updateBlogLike(
            @RequestParam(value = "Id") Long Id) {
        blogService.Updatebloglike(Id);
    }

}



