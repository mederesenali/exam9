package com.example.exam9.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);

    String findByFullName(String email);
}
