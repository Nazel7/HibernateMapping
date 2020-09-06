package com.hibernate.springproject.hibernateclass;

import com.hibernate.springproject.objectClass.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class InstructorFactory {
    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration()
                .configure("hibernate.cfg1.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        try(sessionFactory; session){
            session.beginTransaction();
            Course course= new Course("Molecular Biology and Immunochemistry");
            Course course1= new Course("Integrated BioScience");
            System.out.println("Session connecting...");
            int courseID= 2 ;
            Course course2= session.get(Course.class,courseID);
            Student student= new Student("Lanre", "Tijani", "lanre)2@yahoo.com");
            Student student1= new Student("Asake", "Olaorebikan", "Asa01@gmail.com");
            Review review= new Review("This is the perfect course for me");
            Review review1= new Review("'A' is sure this semester; love this course!");
            course2.addStudentToCourse(student);
            course2.addStudentToCourse(student1);
            course2.addReview(review);
            course2.addReview(review1);
            System.out.println("operation begins");
                session.save(student);
                session.save(student1);
                session.save(review);
                session.save(review1);
        session.getTransaction().commit();
            System.out.println("Operation completed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
