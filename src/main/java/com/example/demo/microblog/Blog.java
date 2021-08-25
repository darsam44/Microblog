package com.example.demo.microblog;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Blog {
    @Id
    @SequenceGenerator( name = "student_sequence",
                        sequenceName = "student_sequence",
                        allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private  Long id;
    private String blogname;
    private String text;
    private LocalDate uploadblog;
//    @Transient  // this field right you dont neew to be colum in our database
    private Integer likes;

    public Blog() {
    }

    public Blog(String blogname, String text, LocalDate uploadblog) {
        this.blogname = blogname;
        this.text = text;
        this.uploadblog = uploadblog;
        this.likes = 0;
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
        return "Student{" +
                "id=" + id +
                ", name='" + blogname + '\'' +
                ", email='" + text + '\'' +
                ", dob=" + uploadblog +
                ", age=" + likes +
                '}';
    }
}
