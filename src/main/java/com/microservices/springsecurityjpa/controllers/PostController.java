package com.microservices.springsecurityjpa.controllers;

import com.microservices.springsecurityjpa.models.Post;
import com.microservices.springsecurityjpa.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    //only ROLE_ADMIN
    @RequestMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @RequestMapping("/posts/{id}")
    public Optional<Post> getPost(@PathVariable Integer id){
        return postService.getPost(id);
    }

    @RequestMapping("/user/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable Integer id){
        return postService.getAllPosts(id);
    }
}
