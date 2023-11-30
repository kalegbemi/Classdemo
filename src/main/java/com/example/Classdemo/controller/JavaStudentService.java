package com.example.Classdemo.controller;

import com.example.Classdemo.Exceptions.StudentNotFoundException;
import com.example.Classdemo.Model.JavaStudent;
import com.example.Classdemo.repository.JavaStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class JavaStudentService {
    @Autowired
    private JavaStudentRepository javaStudentRepository;

    public ResponseEntity<JavaStudent> saveStudent(JavaStudent javaStudent){
        javaStudentRepository.save(javaStudent);
        // return ResponseEntity.ok(javaStudentRepository.save(javaStudent))
        return ResponseEntity.ok(javaStudent);
    }
    public ResponseEntity<List<JavaStudent>> getAllStudent(){
        return ResponseEntity.ok(javaStudentRepository.findAll());
    }
    public ResponseEntity<JavaStudent> getStudentById(Integer id){
        JavaStudent student = javaStudentRepository.findById(id).orElseThrow
                (()-> new StudentNotFoundException("Java student not found"));
        return ResponseEntity.ok(student);
    }

    public ResponseEntity<JavaStudent> getByStudentEmail(String email){
        JavaStudent student = javaStudentRepository.findByEmail(email).orElseThrow(()-> new StudentNotFoundException
                (String.format("Java student with %s email was not found",email)));
        return new ResponseEntity<>(student, HttpStatusCode.valueOf(200));

        //return ResponseEntity.ok(javaStudentRepository.findByEmail(email).orElse(null));
    }
    public List<JavaStudent> getStudentByFirstname(String firstName){
        return javaStudentRepository.findByFirstName(firstName);
    }

    public JavaStudent updateStudentsInfo(Integer id, JavaStudent javaStudent){
        JavaStudent toBeUpdated = javaStudentRepository.findById(id).orElseThrow(()->new StudentNotFoundException
                (String.format("Java student with %d id not found",id)));
        //update vatriables
        assert toBeUpdated != null;
        toBeUpdated.setFirstName(javaStudent.getFirstName());
        toBeUpdated.setLastName(javaStudent.getLastName());
        toBeUpdated.setAge(javaStudent.getAge());
        toBeUpdated.setCourse(javaStudent.getCourse());
        toBeUpdated.setSex(javaStudent.getSex());
        toBeUpdated.setEmail(javaStudent.getEmail());

        return javaStudentRepository.save(toBeUpdated);
    }


    public String deleteStudentById(Integer id){
        javaStudentRepository.deleteById(id);
        return String.format("The Java student with ID %d has been DELETED",id);
    }
    /*@DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteJavaStudent(@PathVariable int id){
        javaStudentRepository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }*/

}


