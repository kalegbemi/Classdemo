package com.example.Classdemo;

import com.example.Classdemo.Model.JavaStudent;
import com.example.Classdemo.Model.JavaStudentResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        /*String url = "http://localhost:8080/api/student";
        JavaStudent javaStudent = new JavaStudent("man","dama","male",22,"kyd@email.com","Java1234");
        ResponseEntity<JavaStudent> response = restTemplate.postForEntity(url, javaStudent, JavaStudent.class);
        JavaStudent extracted = response.getBody();
*/
        /*String url1 = "http://localhost:8080/api/student/10";
        ResponseEntity<JavaStudent> response1 = restTemplate.getForEntity(url1, JavaStudent.class);
        System.out.println(response1.getBody());
*/
       /* String url = "http://localhost:8080/api/students/10";
        JavaStudent javaStudent = new JavaStudent("manman","damadada","female",35,"dada@email.com","Java1234");
        restTemplate.put(url, javaStudent);*/

        /*String url2 = "http://localhost:8080/api/student/10";
        ResponseEntity<JavaStudent> response2 = restTemplate.getForEntity(url2, JavaStudent.class);
        System.out.println(response2.getBody());*/
//        String url = "http://localhost:8080/api/delete/1";
//        restTemplate.delete(url);

        String url = "http://localhost:8080/api/resources/test/2";
        ResponseEntity<JavaStudentResource> response3 = restTemplate.getForEntity(url, JavaStudentResource.class);
            System.out.println(response3.getHeaders());









    }
}
