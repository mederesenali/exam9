package com.example.exam9.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    private String commnet;
    @ManyToOne(fetch =FetchType.LAZY)
    private Customer customer;
    @ManyToOne(fetch =FetchType.LAZY)
    private Post post;
    private LocalDate createDate;


}
