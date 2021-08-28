package com.example.demo.controller;


import com.example.demo.microblog.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/blog")
public class BlogController {


    private final BlogService blogService;


    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    // return all Blogs in the database
    @GetMapping("/trending")
    public Iterable<Blog> getBlogs(){

        return blogService.getblogs();
    }

    // find Blog by Blog name
    @GetMapping(value = "/trending/blogname/{Blogname}" )
    public Blog getBlogByName(@PathVariable String Blogname){
        return blogService.getBlogByName(Blogname);
    }

    //find Blog by ID
    @GetMapping(value = "/trending/id/{Id}" )
    public Blog getBlogById(@PathVariable Long Id){
        return blogService.getBlogById(Id);
    }

    // add new Blog to Database
    @PostMapping
    public void makeNewSBlog (@RequestBody Blog blog){
        blogService.addNewBlog(blog);
    }

    //delete Blog by ID
    @DeleteMapping("/delete")
    public void deleteBlog(@RequestParam(value = "Id") Long Id){
        blogService.deleteblog(Id);
    }

    // Update Blog by ID
    @PutMapping(path = "{blogId}")
    public void updateBlog(
            @PathVariable("blogId") Long blogId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String text) {
        blogService.Updateblog(blogId , name , text);
     }

     // give post like by ID
    @PutMapping("/Upvote")
    public void updateBlogLike(
            @RequestParam(value = "Id") Long Id) {
        blogService.Updatebloglike(Id);
    }

}



