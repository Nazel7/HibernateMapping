package com.hibernate.springproject.objectClass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
@Access(AccessType.FIELD)
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name= "course_student",
            joinColumns=@JoinColumn(name= "student_id"),
            inverseJoinColumns = @JoinColumn(name= "course_id")
    )
    private List<Course> courses;

    public Student(){
        super();
    }

    public Student(String firstName, String lastName, String email) {
        this.courses= new ArrayList<>();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public void addCourseToStudent(Course course){
        this.courses.add(course);
    }
    @Override
    public String toString() {
        return "Instructor: " + this.firstName + " " + this.lastName + "\n" +
                this.email;
    }
}
