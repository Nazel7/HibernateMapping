package com.hibernate.springproject.objectClass;

import javax.persistence.*;

@Entity
@Table(name= "review")
@Access(value = AccessType.FIELD)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private int id;
    @Column(name= "title")
    private String title;
//    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
//            CascadeType.PERSIST, CascadeType.REFRESH})
//    private Course courseID;

    public Review(){
        super();
    }

    public Review(String title) {
        this.title = title;
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

//    public Course getCourseID() {
//        return courseID;
//    }
//
//    public void setCourseID(Course courseID) {
//        this.courseID = courseID;
//    }
}

