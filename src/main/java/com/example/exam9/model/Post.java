package com.example.exam9.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String content;
    private LocalDate createDate;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Customer author;
    private String authorName;
   @OneToMany(mappedBy = "post")
    List<Comment> comments;





}
