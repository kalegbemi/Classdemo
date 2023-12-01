package com.example.Classdemo.repository;

import com.example.Classdemo.Model.JavaStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface JavaStudentRepository extends JpaRepository<JavaStudent, Integer> {

    List<JavaStudent> findByFirstName(String firstName);
    Optional<JavaStudent> findByEmail(String email);

}
