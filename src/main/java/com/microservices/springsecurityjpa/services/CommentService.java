package com.microservices.springsecurityjpa.services;

import com.microservices.springsecurityjpa.models.Comment;
import com.microservices.springsecurityjpa.models.Post;
import com.microservices.springsecurityjpa.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllComments(){
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll()
                .forEach(comments::add);
        return comments;
    }

    public List<Comment> getAllComments(Integer userId){
        List<Comment> comments = new ArrayList<>();
        commentRepository.findByUserUseId(userId)
                .forEach(comments::add);
        return comments;
    }

    public List<Comment> getAllCommentsByPostId(Integer postId){
        List<Comment> comments = new ArrayList<>();
        commentRepository.findByPostPosId(postId)
                .forEach(comments::add);
        return comments;
    }

    public Optional<Comment> getComment(Integer id){
        return commentRepository.findById(id);
    }

    public void addPost(Comment comment){
        commentRepository.save(comment);
    }

    public void updatePost(Comment comment){
        commentRepository.save(comment);
    }
}
