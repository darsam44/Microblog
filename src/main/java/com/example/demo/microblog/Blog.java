package com.example.demo.microblog;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Blog implements Comparable<Blog> {
    @Id
    @SequenceGenerator( name = "blog_sequence",
                        sequenceName = "blog_sequence",
                        allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blog_sequence"
    )

    private  Long id;
    private String blogname;
    private String text;
    private LocalDate uploadblog;
    private Integer likes;

    public Blog() { }

    public Blog(String blogname, String text) {
        this.blogname = blogname;
        this.text = text;
        this.uploadblog = LocalDate.now();
        this.likes = 0;
    }

    public Blog(String blogname, String text, Integer like) {
        this.blogname = blogname;
        this.text = text;
        this.uploadblog = LocalDate.now();
        this.likes = like;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogname;
    }

    public void setBlogName(String blogname) {
        this.blogname = blogname;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getUploadblog() {
        return uploadblog;
    }

    public void setUploadblog(LocalDate uploadblog) {
        this.uploadblog = uploadblog;
    }

    public Integer getLikes() {
        return this.likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + blogname + '\'' +
                ", email='" + text + '\'' +
                ", dob=" + uploadblog +
                ", age=" + likes +
                '}';
    }


    // make a compre to know how to sort the array
    @Override
    public int compareTo(Blog other_blog) {
       if(other_blog.getUploadblog().isAfter(getUploadblog()) || other_blog.getUploadblog().isEqual(getUploadblog())){
           if( getLikes() > other_blog.getLikes()){
               return -1;
           }
           else {
               return 1;
           }
       }
       else {
           return 1;
       }
    }
}
