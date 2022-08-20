package com.in28minutes.jpa.hibernate.demo;

import com.in28minutes.jpa.hibernate.demo.entity.*;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

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

//        studentRepository.insertStudentAndCourse(new Student("Cristiano Ronaldo"), new Course("Futbol 1"));


        employeeRepository.insert(new FullTimeEmployee("Lucas", new BigDecimal(35000)));
        employeeRepository.insert(new PartTimeEmployee("Henrique", new BigDecimal(3500)));

        List<FullTimeEmployee> FTE = employeeRepository.retrieveAllFullTimeEmployees();
        List<PartTimeEmployee> PTE = employeeRepository.retrieveAllPartTimeEmployees();

        logger.info("List of FTE employees: ", FTE);
        logger.info("List of PTE employees: ", PTE);

    }
}
