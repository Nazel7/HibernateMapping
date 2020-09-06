package com.hibernate.springproject.objectClass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "course")
@Access(value= AccessType.FIELD)
public class Course {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name= "title")
    private String title;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name= "instructor_id")
    private Instructor instructorID;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "course_id")
    private List<Review> reviewList;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name= "course_student",
            joinColumns=@JoinColumn(name= "course_id"),
            inverseJoinColumns = @JoinColumn(name= "student_id")
    )
    private List<Student> students;

    public Course(){
        super();
    }

    public Course(String title) {
        this.title = title;
        reviewList= new ArrayList<>();
        students= new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructorID() {
        return instructorID;
    }

    public void setInstructorID(Instructor instructorID) {
        this.instructorID = instructorID;
    }
    public void addReview(Review review){
        this.reviewList.add(review);
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addStudentToCourse(Student student){
        this.students.add(student);
    }

    @Override
    public String toString() {
        for(Review c: this.reviewList){
            return "Course Title: "+ this.title+ "\nCourse Review:" + c.getTitle();
        }
       return null;
    }
}
