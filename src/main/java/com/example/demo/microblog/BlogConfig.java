package com.example.demo.microblog;


import com.example.demo.repository.BlogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class BlogConfig {

    @Bean
    CommandLineRunner commandLineRunner(BlogRepository repository){
        return args ->{
        Blog Blog1 = new Blog(
                    "First Blog" ,
                    "this is my first blog"
                    );

        Blog Blog2 =   new Blog(
                    "Second Blog" ,
                    "My second blog is on.."
            );
            Blog Blog3 =   new Blog(
                    "Third Blog" ,
                    "My third blog is on.."
            );

        repository.saveAll(List.of(Blog1,Blog2,Blog3));

        };
        }

    }


