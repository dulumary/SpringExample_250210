package com.marondal.spring.ex.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marondal.spring.ex.jpa.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
