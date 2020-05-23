package com.example.exam9.controller;

import com.example.exam9.model.*;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.awt.print.Pageable;
import java.security.Principal;
import java.time.LocalDate;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PostService postService;
    @GetMapping("/createPost")
    public String postCreation(Model model){


        return "post";
    }
    @PostMapping("/createPost")
    public String add(Principal principal, @AuthenticationPrincipal Customer user,
                      @RequestParam String name,
                      @RequestParam String content , Model model) {
        LocalDate localDate =LocalDate.now();
      var authorName= principal.getName();
        Post post = new Post();
        post.setName(name);
        post.setContent(content);
        post.setCreateDate(localDate);
        post.setAuthorName(authorName);
        post.setAuthor(user);
        post.setAuthor(user);
         postRepository.save(post);

        Iterable<Post> posts;
        posts = postRepository.findAll();
        model.addAttribute("posts", posts);


        return "home";
    }
    @PostMapping("/filter")
    public String filter(@RequestParam String search,Model model) {
        Iterable<Post> posts;

        if (search != null && !search.isEmpty()) {
            posts =  postRepository.findAllByName(search);
        } else {
            posts = postRepository.findAll();
        }

        model.addAttribute("posts", posts);

        return "home";
    }
}
