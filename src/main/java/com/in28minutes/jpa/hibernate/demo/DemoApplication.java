package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
//        studentRepository.saveStudentWithPassport();
        //repository.playWithEntityManager();

//        List<Review> reviewList = new ArrayList<>();
//        reviewList.add(new Review("5", "Great haands-on stuff"));
//        reviewList.add(new Review("5", "hats off"));
//        reviewList.add(new Review("5", "hey hey hey"));
//
//        courseRepository.addReviewsForCourse(10003L, reviewList);
//        courseRepository.getReviews();

        studentRepository.insertStudentAndCourse(new Student("Cristiano Ronaldo"), new Course("Futbol 1"));

    }
}
