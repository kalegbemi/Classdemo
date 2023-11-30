package com.example.Classdemo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "java_student", uniqueConstraints = @UniqueConstraint(columnNames = ("email")))
public class JavaStudent {
    /*@Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@NotNull(message = "First name cannot be null")
@NotBlank(message = "First name can not be blank")
@Length(min = 3, message = "First name cannot be less than 3 characters")
    @Column(name = "first_name")
    private String firstName;
    @NotNull(message = "Last name cannot be null")
    @NotBlank(message = "Last name can not be blank")
    @Length(min = 3, message = "Last name cannot be less than3 characters")
    @Column(name = "last_name")
    private String lastName;
    @NotNull(message = "Sex name cannot be null")
    @NotBlank(message = "Sex name can not be blank")
    @Length(min = 3, message = "Sex name cannot be less than3 characters")
    private String sex;
@NotNull
@Min(value = 18, message = "you must be 18 and above")
@Max(value = 70, message = "you must be less than 70 years old")
    private int age;
@Email(message = "Please enter a valid email address")
    private String email;
@Pattern(regexp = "Java[0-9]{4}", message = "Please follow naming pattern (Java####)")
    private String course;
    public JavaStudent(){

    }

    public JavaStudent(String firstName, String lastName, String sex, int age, String email, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.course = course;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "JavaStudent{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
