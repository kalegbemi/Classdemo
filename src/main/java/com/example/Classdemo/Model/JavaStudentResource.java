package com.example.Classdemo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;

public class JavaStudentResource extends RepresentationModel<JavaStudentResource> {
    @Autowired
    private JavaStudent javaStudent;

    public JavaStudent getJavaStudent() {
        return javaStudent;
    }
    public void setJavaStudent(JavaStudent javaStudent) {
        this.javaStudent = javaStudent;

    }
}
