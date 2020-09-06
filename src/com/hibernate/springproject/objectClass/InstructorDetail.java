package com.hibernate.springproject.objectClass;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
@Access(value= AccessType.FIELD)
public class InstructorDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobby")
    private String hobby;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instructorDetailID")
    private Instructor instuctorID;

    public InstructorDetail(){
        super();
    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public Instructor getInstuctorID() {
        return instuctorID;
    }

    public void setInstuctorID(Instructor instuctorID) {
        this.instuctorID = instuctorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Instructor Details: "+ this.youtubeChannel + "\n"+ this.hobby;
    }
}
