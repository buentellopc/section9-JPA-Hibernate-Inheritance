package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import com.in28minutes.jpa.hibernate.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {

        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);

        Course course2 = findById(10001L);

        course2.setName("JPA in 50 Steps - Updated");

    }


    public void addReviewsForCourse(Long courseId, List<Review> reviewList) {
//		get the course with courseId
        Course course = findById(courseId);
        logger.info("course.getReviews() -> {}", course.getReviews());


//		setting the relationship
//		save it to the database
        for (Review review : reviewList) {
			course.addReview(review);
            review.setCourse(course);
//			Think of the following line as if the review were sent to the persistence context just to wait for be
//			saved into the database
            em.persist(review);

        }
        logger.info("new reviews {}", course.getReviews());
    }


    public void getReviews(){
        Course course = em.find(Course.class, 10003L);
        logger.info("All reviews of course 10003 -> {}", course.getReviews());

    }
}
