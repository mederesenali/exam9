package com.example.exam9;

import com.example.exam9.model.Post;
import com.example.exam9.model.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class Exam9Application {

    public static void main(String[] args) {
        SpringApplication.run(Exam9Application.class, args);
    }

    @Bean
    public CommandLineRunner init(PostRepository repository) {
        Post post =new Post();
        return args -> {


        };
    }
}



