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

    public List<Blog> getblogs(){
        return blogRepository.findAll();
    }

    public void addNewBlog(Blog student) {
        Optional<Blog> studentOptional =  blogRepository.findStudentByText(student.getText());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        blogRepository.save(student);
//        System.out.println(student);
    }

    public void deleteblog(Long studentId) {
    Boolean exists = blogRepository.existsById(studentId);

    if (!exists){
        throw new IllegalStateException("blog with id " + studentId + " does not exists" );
    }
        blogRepository.deleteById(studentId);
    }

    @Transactional
    public void Updateblog(Long studentId, String name, String email) {
    Blog student = blogRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exists" ) );

    if ( name != null && name.length() > 0 && !Objects.equals(student.getBlogName() , name)){
        student.setBlogName(name);
    }
    if ( email != null && email.length() > 0 && !Objects.equals(student.getText() , email)){
            Optional<Blog> studentOptional = blogRepository.findStudentByText(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setText(email);
    }
    }
}


