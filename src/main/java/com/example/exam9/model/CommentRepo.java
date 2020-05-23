package com.example.exam9.model;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment,Integer> {
}
