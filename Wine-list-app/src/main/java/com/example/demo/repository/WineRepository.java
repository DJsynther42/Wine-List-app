package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long>{

}
