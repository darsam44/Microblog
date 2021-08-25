package com.example.demo.microblog;


import com.example.demo.repository.BlogRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(BlogRepository repository){
        return args ->{
        Blog mariam = new Blog(
                    "Miraim" ,
                    "mariam@gmail.com",
                    LocalDate.of(2000, Month.JANUARY , 5)
                    );

        Blog Alex =   new Blog(
                "Alex" ,
                "Alex@gmail.com",
                LocalDate.of(2004, Month.JANUARY , 5)
                );

        repository.saveAll(List.of(mariam,Alex));

        };
        }

    }


