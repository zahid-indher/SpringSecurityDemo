package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.model.Students;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Long>{

}
