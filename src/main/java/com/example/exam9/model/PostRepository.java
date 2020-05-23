package com.example.exam9.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Integer> {

    Iterable<Post> findAllByName(String search);
}
