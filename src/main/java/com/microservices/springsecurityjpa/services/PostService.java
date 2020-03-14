package com.microservices.springsecurityjpa.services;

import com.microservices.springsecurityjpa.models.Post;
import com.microservices.springsecurityjpa.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        List<Post> posts = new ArrayList<>();
        postRepository.findAll()
                .forEach(posts::add);
        return posts;
    }

    public List<Post> getAllPosts(Integer userId){
        List<Post> posts = new ArrayList<>();
        postRepository.findPostsByUserUseId(userId)
                .forEach(posts::add);
        return posts;
    }

    public Optional<Post> getPost(Integer id){
        return postRepository.findById(id);
    }

    /*
    public void addPost(Post post){
        postRepository.save(post);
    }

    public void updatePost(Post post){
        postRepository.save(post);
    }
    */
}
