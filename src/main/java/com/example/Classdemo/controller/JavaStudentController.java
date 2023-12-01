package com.example.Classdemo.controller;

import com.example.Classdemo.Model.JavaStudent;
import com.example.Classdemo.Model.JavaStudentResource;
import com.example.Classdemo.repository.JavaStudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JavaStudentController {
    @Autowired
    private JavaStudentService javaStudentService;

    @PostMapping("/student")
    public ResponseEntity<JavaStudent> saveStudent(@Valid @RequestBody JavaStudent javaStudent){
      /*javaStudentService.saveStudent(javaStudent);
         return ResponseEntity.ok(javaStudent);*/
       // return ResponseEntity.ok(javaStudentRepository.save(javaStudent)) //(comment) -> this is for when this class was directly
        // connect to the JavaStudentRepository interface.
        return ResponseEntity.ok(javaStudentService.saveStudent(javaStudent).getBody());
    }
    @PostMapping(path = "savelist")
    public List<JavaStudent> saveListOfStudent(@RequestBody List<JavaStudent> javaStudents){
        return javaStudentService.saveListOfStudents(javaStudents);
    }

    @GetMapping("/student")
    //@GetMapping(value = "/student", produces = MediaType.APPLICATION_PDF)
    //@GetMapping(value = "/student", produces = "application/xml")
    public ResponseEntity<List<JavaStudent>> getAllStudent(){
       return ResponseEntity.ok(javaStudentService.getAllStudent().getBody());
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<JavaStudent> getStudentById(@PathVariable Integer id){
       // JavaStudent student = javaStudentService.getStudentById(id).getBody();
        // return ResponseEntity.ok(student);
        return ResponseEntity.ok(javaStudentService.getStudentById(id).getBody());

    }

    @GetMapping("/student/email/{email}")
    public ResponseEntity<JavaStudent> getByStudentByEmail(@PathVariable String email){
        JavaStudent student = javaStudentService.getByStudentEmail(
                email).getBody();
        return new ResponseEntity<>(student, HttpStatusCode.valueOf(200));

        //return ResponseEntity.ok(javaStudentRepository.findByEmail(email).orElse(null));
    }

    @GetMapping("/student/names/{firstName}")
    public List<JavaStudent> getStudentByFirstname(@PathVariable String firstName){
        return javaStudentService.getStudentByFirstname(firstName);
    }

    @PutMapping("/students/{id}")
    public JavaStudent updateStudentsInfo( @PathVariable Integer id, @RequestBody @Valid JavaStudent javaStudent){
       /* JavaStudent toBeUpdated = javaStudentService.getStudentById(id).getBody();
        //update variables
        assert toBeUpdated != null;
        toBeUpdated.setFirstName(javaStudent.getFirstName());
        toBeUpdated.setLastName(javaStudent.getLastName());
        toBeUpdated.setAge(javaStudent.getAge());
        toBeUpdated.setCourse(javaStudent.getCourse());
        toBeUpdated.setSex(javaStudent.getSex());
        toBeUpdated.setEmail(javaStudent.getEmail());

        return javaStudentService.saveStudent(toBeUpdated).getBody();*/
        return javaStudentService.updateStudentsInfo(id, javaStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Integer id){
        return javaStudentService.deleteStudentById(id);
       // return String.format("The Java student with ID %d has been DELETED",id);
    }
    /*@DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteJavaStudent(@PathVariable int id){
        javaStudentRepository.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }*/
    /*@GetMapping("/resources/{id}")
    public ResponseEntity<JavaStudentResource> getJavaStudentResource(@PathVariable int id){
        JavaStudent javaStudent = getStudentById(id).getBody();

        JavaStudentResource javaStudentResource = new JavaStudentResource();
        javaStudentResource.setJavaStudent(javaStudent);
        Link getbyId = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .getStudentById(id)).withRel("getstudentbyid");
        Link deletebyid = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .deleteStudentById(id)).withSelfRel();
        Link updateById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .updateStudentsInfo(id, javaStudent)).withRel("updatewithid");
        Link getALL = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .getAllStudent()).withRel("showall");
        javaStudentResource.add(getbyId, deletebyid, updateById, getALL);
        return new ResponseEntity<>(javaStudentResource, HttpStatus.OK);
    }*/
   /* @GetMapping("/resources/name/{firstName}")
    public JavaStudentResource getResourceByFirstName(String firstName){
        List<JavaStudent> javaStudent = getStudentByFirstname(firstName);
        JavaStudentResource javaStudentResource = new JavaStudentResource();

        Link getByFirstname = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .getStudentByFirstname(firstName)).withRel("getByFirstName");

        javaStudentResource.add(getByFirstname);
        return new JavaStudentResource();
    }*/
//@Autowired
   // private JavaStudentResource javaStudentResource;

    @GetMapping("/resources/test/{id}")
    public ResponseEntity<JavaStudentResource> getJavaStudentResource(@PathVariable Integer id){
        JavaStudent javaStudent = getStudentById(id).getBody();

        JavaStudentResource javaStudentResource = new JavaStudentResource();
        javaStudentResource.setJavaStudent(javaStudent);
        assert javaStudent != null;
        Link getById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .getStudentById(id)).withRel("getStudentById");
        Link deleteById = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .deleteStudentById(id)).withRel("deleteById");
        Link allStudents = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .getAllStudent()).withRel("allStudents");
        Link getByFirstName = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .getStudentByFirstname(javaStudent.getFirstName())).withRel("getbyfirstname");
        Link getByEmail = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavaStudentController.class)
                .getByStudentByEmail(javaStudent.getEmail())).withRel("getbyemail");
        javaStudentResource.add(getById, deleteById, allStudents, getByFirstName, getByEmail);
        return new ResponseEntity<>(javaStudentResource, HttpStatus.OK);
    }


}
