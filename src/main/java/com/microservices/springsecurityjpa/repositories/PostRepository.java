package com.microservices.springsecurityjpa.repositories;

import com.microservices.springsecurityjpa.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {

    public List<Post> findPostsByUserUseId(Integer userId);
}
