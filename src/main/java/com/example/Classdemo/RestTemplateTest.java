package com.example.Classdemo;

import com.example.Classdemo.Model.JavaStudent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/api/student";
        JavaStudent javaStudent = new JavaStudent("man","dama","male",22,"kyd@email.com","Java1234");
        ResponseEntity<JavaStudent> response = restTemplate.postForEntity(url, javaStudent, JavaStudent.class);
        JavaStudent extracted = response.getBody();
        System.out.println(extracted);
    }
}
