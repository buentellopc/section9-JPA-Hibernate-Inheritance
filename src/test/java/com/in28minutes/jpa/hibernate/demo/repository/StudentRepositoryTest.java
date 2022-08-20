package com.in28minutes.jpa.hibernate.demo.repository;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    //	Session & Session Factory
//	EntityManager & Persistence Context
//	Transaction


    @Test
    public void someTest() {
        repository.understandPersistenceContext();
    }


    @Transactional
    @Test
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());

    }

    @Transactional
    @Test
    public void retrievePassportAndStudentDetails() {
        Passport passport = em.find(Passport.class, 40002L);
        logger.info("passport -> {}", passport);
        logger.info("student retrieved using passport instance -> {}", passport.getStudent());
    }


    @Transactional
    @Test
    public void retrieveStudentAndCourses() {
        Student student = repository.findById(20001L);
        logger.info("student -> {}", student);
        logger.info("student is enrolled in the following courses: {}", student.getCourses());

    }


}
