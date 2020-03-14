package com.microservices.springsecurityjpa.controllers;

import com.microservices.springsecurityjpa.models.Comment;
import com.microservices.springsecurityjpa.models.Post;
import com.microservices.springsecurityjpa.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    //only ROLE_ADMIN
    @RequestMapping("/comments")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @RequestMapping("/comments/{id}")
    public Optional<Comment> getComment(@PathVariable Integer id){
        return commentService.getComment(id);
    }

    @RequestMapping("/user/{id}/comments")
    public List<Comment> getCommentsByUserId(@PathVariable Integer id){
        return commentService.getAllComments(id);
    }

    @RequestMapping("/posts/{id}/comments")
    public List<Comment> getCommentsByPostId(@PathVariable Integer id){
        return commentService.getAllCommentsByPostId(id);
    }
}
